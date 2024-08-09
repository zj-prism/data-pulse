package top.primsnet.sync.business.datasource.service.impl;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.noear.esearchx.EsContext;
import org.noear.solon.Solon;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.BeanWrap;
import org.noear.solon.core.Props;
import org.noear.solon.data.dynamicds.DynamicDataSource;
import top.primsnet.sync.business.datasource.service.DataSourceService;
import top.primsnet.sync.business.datasource.to.CreateDataSourceStrTO;
import top.primsnet.sync.common.enums.SysCommonEnum;
import top.primsnet.sync.common.exception.ServiceException;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @Author: joshua
 * @Description: es数据源实现
 * @DateTime: 2024/8/8 18:59
 **/
@Component("ElasticSearchDataSourceServiceImpl")
@Slf4j
public class ElasticSearchDataSourceServiceImpl implements DataSourceService {

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
                dataSourceStrTO.getUrl(), dataSourceStrTO.getUserName())){
            throw new ServiceException("创建数据源动态加载json字符串失败，参数校验失败");
        }
        //构建动态加载数据源json串
        JSONObject configJson = new JSONObject();
        configJson.set("url",dataSourceStrTO.getUrl());
        configJson.set("username",dataSourceStrTO.getUserName());
        configJson.set("password",dataSourceStrTO.getPassword());
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
        if (StrUtil.hasEmpty(beanName,configJsonStr)){
            throw new ServiceException("加载es数据源失败,参数校验失败-参数不完整");
        }
        //json格式校验
        if (!JSONUtil.isTypeJSON(configJsonStr)){
            throw new ServiceException("当前数据源配置json字符串格式错误,请检查数据源配置或重新配置数据源");
        }
        try {
            log.info("开始加载es数据源,名称:{},配置:{}",beanName,configJsonStr);
            Props props = new Props();
            props.loadAdd(Utils.buildProperties(configJsonStr));
            EsContext ds = props.getBean(EsContext.class);
            //包装Bean（指定名字的）
            BeanWrap beanWrap = Solon.context().wrap(beanName, ds);
            //以名字注册
            Solon.context().putWrap(beanName, beanWrap);
            log.info("加载es数据源成功,名称：{}",beanName);
        } catch (Exception e) {
            log.error("加载es数据源失败，名称:{},配置:{},异常:{}",beanName,configJsonStr, ExceptionUtil.stacktraceToString(e));
            throw new ServiceException("加载es数据源失败,名称：%s,异常：%s".formatted(beanName,ExceptionUtil.stacktraceToString(e)));
        }
    }

    /**
     * 卸载数据源
     *
     * @param beanName bean名称
     */
    @Override
    public void logoutDataSource(String beanName) {
        if (StrUtil.isEmpty(beanName)){
            throw new ServiceException("卸载es数据源失败,参数校验失败-参数不完整");
        }
        Solon.context().putWrap(beanName, null);
    }
}
