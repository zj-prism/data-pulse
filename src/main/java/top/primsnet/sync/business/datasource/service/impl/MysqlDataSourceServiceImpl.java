package top.primsnet.sync.business.datasource.service.impl;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.Props;
import org.noear.solon.data.dynamicds.DynamicDataSource;
import org.noear.solon.data.dynamicds.DynamicDsKey;
import org.noear.wood.annotation.Db;
import top.primsnet.sync.business.datasource.mapper.MysqlDataSourceMapper;
import top.primsnet.sync.business.datasource.service.DataSourceService;
import top.primsnet.sync.business.datasource.to.CreateDataSourceStrTO;
import top.primsnet.sync.business.datasource.to.GetDataSourceFieldsTO;
import top.primsnet.sync.common.enums.SysCommonEnum;
import top.primsnet.sync.common.exception.ServiceException;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    @Db("db1")
    MysqlDataSourceMapper mysqlDataSourceMapper;

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
//            throw new ServiceException("卸载mysql数据源失败,名称：%s,数据源不存在".formatted(beanName));
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
    public List<GetDataSourceFieldsTO> getFields(String beanName, String tableName) {
        if (StrUtil.isEmpty(beanName)) {
            throw new ServiceException("获取数据源字段mysql数据源失败,参数校验失败-参数不完整");
        }
        //获取数据源
        DataSource dataSource = dds.getTargetDataSource(beanName);
        if (ObjUtil.isEmpty(dataSource)) {
            throw new ServiceException("获取数据源字段mysql数据源失败,名称：%s,数据源不存在".formatted(beanName));
        }
        Connection connection =null;
        Statement statement =null;
        try {
            DynamicDsKey.setCurrent(beanName);
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            String sql = "select column_name as fieldName,column_comment as fieldAnnotation,data_type as fieldType\n" +
                    " from information_schema.columns where table_schema = 'sss' and  table_name = 'test'";
            boolean execute = statement.execute(sql);
            if (execute) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    //todo 需要提取工具类
                    //todo 组装结果
                    System.out.println(resultSet.getString("fieldName") + "-"
                            + resultSet.getString("fieldAnnotation") + "-" + resultSet.getString("fieldType"));
                }
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            log.error("执行获取mysql字段异常,表:{},异常:{}", tableName, ExceptionUtil.stacktraceToString(e));
        } finally {
            if (ObjUtil.isNotNull(statement)){
                try {
                    statement.close();
                } catch (SQLException e) {
                    log.error("关闭statement异常:{}",ExceptionUtil.stacktraceToString(e));
                }
            }
            if (ObjUtil.isNotNull(connection)){
                try {
                    connection.close();
                } catch (SQLException e) {
                    log.error("关闭connection异常:{}",ExceptionUtil.stacktraceToString(e));
                }
            }
            DynamicDsKey.setCurrent("db1");
        }
        return null;
    }
}
