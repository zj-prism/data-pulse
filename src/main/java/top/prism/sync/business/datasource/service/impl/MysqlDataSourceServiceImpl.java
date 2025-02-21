package top.prism.sync.business.datasource.service.impl;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Entity;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.AES;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.Props;
import org.noear.solon.data.dynamicds.DynamicDataSource;
import org.noear.solon.data.dynamicds.DynamicDsKey;
import top.prism.sync.business.datasource.service.DataSourceService;
import top.prism.sync.business.datasource.to.CreateDataSourceStrTO;
import top.prism.sync.business.datasource.to.GetDataSourceFieldsTO;
import top.prism.sync.business.datasource.utils.MysqlSqlExecuteUtil;
import top.prism.sync.common.enums.SysCommonEnum;
import top.prism.sync.common.exception.ServiceException;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: joshua
 * Description: mysql数据源实现
 * DateTime: 2024/8/8 18:59
 **/
@Component("MysqlDataSourceServiceImpl")
@Slf4j
public class MysqlDataSourceServiceImpl implements DataSourceService {

    @Inject
    DynamicDataSource dds;

    @Inject("${mpw.key}")
    private String MPMPW_KEY;

    /**
     * 创建数据源的动态加载json
     *
     * @param dataSourceStrTO 请求体
     * @return json字符串
     */
    @Override
    public String createDataSourceStr(CreateDataSourceStrTO dataSourceStrTO) {
        //参数校验
        if (ObjUtil.hasEmpty(dataSourceStrTO.getBeanName(), dataSourceStrTO.getPassword(), dataSourceStrTO.getType(),
                dataSourceStrTO.getUrl(), dataSourceStrTO.getUserName())) {
            throw new ServiceException("创建数据源动态加载json字符串失败，参数校验失败");
        }
        //判断链接是否需要加密
        if (StrUtil.isNotBlank(MPMPW_KEY)){
            //如果配置了密钥，则需要加密
            dataSourceStrTO.setUrl("mpw:"+ AES.encrypt(dataSourceStrTO.getUrl(),MPMPW_KEY));
            dataSourceStrTO.setUserName("mpw:"+ AES.encrypt(dataSourceStrTO.getUserName(),MPMPW_KEY));
            dataSourceStrTO.setPassword("mpw:"+ AES.encrypt(dataSourceStrTO.getPassword(),MPMPW_KEY));
        }
        //构建动态加载数据源json串
        JSONObject configJson = new JSONObject();
        configJson.set("driverClassName", SysCommonEnum.MYSQL_8_DRIVER_CLASS_NAME.getValue());
        configJson.set("type", SysCommonEnum.DATA_SOURCE_POOL_TYPE.getValue());
        configJson.set("strict", SysCommonEnum.DATA_SOURCE_STRICT_CLOSE_TYPE.getValue());
        configJson.set("jdbcUrl", dataSourceStrTO.getUrl());
        configJson.set("username", dataSourceStrTO.getUserName());
        configJson.set("password", dataSourceStrTO.getPassword());
        return JSONUtil.toJsonStr(configJson);
    }

    /**
     * 加载数据源
     *
     * @param beanName      bean名称
     * @param configJsonStr 配置json字符串
     *                      由{@code createDataSourceStr}方法构建
     */
    @Override
    public void initDataSource(String beanName, String configJsonStr) {
        if (StrUtil.hasEmpty(beanName, configJsonStr)) {
            throw new ServiceException("加载mysql数据源失败,参数校验失败-参数不完整");
        }
        //json格式校验
        if (!JSONUtil.isTypeJSON(configJsonStr)) {
            throw new ServiceException("当前数据源配置json字符串格式错误,请检查数据源配置或重新配置数据源");
        }
        try {
            log.info("开始加载mysql数据源,名称:{},配置:{}", beanName, configJsonStr);
            Props props = new Props();
            props.loadAdd(Utils.buildProperties(configJsonStr));
            DataSource ds = props.toBean(HikariDataSource.class);
            dds.addTargetDataSource(beanName, ds);
            //获取数据源
            DataSource dataSource = dds.getTargetDataSource(beanName);
            log.info("加载数据源后获取数据源成功,bean名称:{},数据源:{}", beanName, dataSource);
            if (ObjUtil.isEmpty(dataSource)) {
                throw new ServiceException("加载mysql数据源失败,名称：%s,数据源添加后未获取到".formatted(beanName));
            }
            log.info("加载mysql数据源成功,名称：{}", beanName);
        } catch (Exception e) {
            log.error("加载mysql数据源失败，名称:{},配置:{},异常:{}", beanName, configJsonStr, ExceptionUtil.stacktraceToString(e));
            throw new ServiceException("加载mysql数据源失败,名称：%s,异常：%s".formatted(beanName, ExceptionUtil.stacktraceToString(e)));
        }
    }

    /**
     * 卸载数据源
     *
     * @param beanName bean名称
     */
    @Override
    public void logoutDataSource(String beanName) {
        if (StrUtil.isEmpty(beanName)) {
            throw new ServiceException("卸载mysql数据源失败,参数校验失败-参数不完整");
        }
        //获取数据源
        DataSource dataSource = dds.getTargetDataSource(beanName);
        if (ObjUtil.isEmpty(dataSource)) {
            log.warn("卸载mysql数据源失败,名称：%s,数据源不存在,请确认服务是否正常".formatted(beanName));
        }
        //卸载数据源
        try {
            dds.removeTargetDataSource(beanName);
            log.info("卸载mysql数据源成功,名称：{}", beanName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("卸载数据源失败,bean名称：%s,异常:%s".formatted(beanName, ExceptionUtil.stacktraceToString(e)));
        }
    }

    /**
     * 获取数据源字段
     *
     * @param beanName  数据源
     * @param tableName 表明
     * @return 字段集合
     */
    @Override
    public synchronized List<GetDataSourceFieldsTO> getFields(String beanName, String tableName) {
        if (StrUtil.isEmpty(beanName) || StrUtil.isEmpty(tableName)) {
            throw new ServiceException("获取数据源字段mysql数据源失败,参数校验失败-参数不完整");
        }
        return getFieldsExec(beanName, tableName);
    }

    /**
     * 获取mysql表字段
     * @param beanName bean名称
     * @param tableName 表名称
     * @return
     */
    private synchronized List<GetDataSourceFieldsTO> getFieldsExec(String beanName, String tableName) {
        //获取数据源
        List<GetDataSourceFieldsTO> list = new ArrayList<>();
        try {
            DataSource dataSource = dds.getTargetDataSource(beanName);
            if (ObjUtil.isEmpty(dataSource)) {
                throw new ServiceException("获取数据源字段mysql数据源失败,名称：%s,数据源不存在".formatted(beanName));
            }
            list = new ArrayList<>();
            String sql = "select column_name as fieldName,column_comment as fieldAnnotation,data_type as fieldType " +
                    "from information_schema.columns where table_name = '{}'";
            sql = StrUtil.format(sql, tableName);
            List<Entity> dataList = MysqlSqlExecuteUtil.exec(dataSource, sql);
            for (Entity data : dataList) {
                GetDataSourceFieldsTO fieldsTO = new GetDataSourceFieldsTO();
                fieldsTO.setFieldName(data.getStr("fieldName"));
                fieldsTO.setFieldType(data.getStr("fieldType"));
                fieldsTO.setFieldAnnotation(data.getStr("fieldAnnotation"));
                list.add(fieldsTO);
            }
        } catch (Exception e){
            log.error("获取数据源字段mysql数据源失败,名称：%s,异常:%s".formatted(beanName, ExceptionUtil.stacktraceToString(e)));
        }finally {
            DynamicDsKey.setCurrent("db1");
        }
        return list;
    }
}
