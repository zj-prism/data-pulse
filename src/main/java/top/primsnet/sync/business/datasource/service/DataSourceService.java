package top.primsnet.sync.business.datasource.service;


import top.primsnet.sync.business.datasource.to.CreateDataSourceStrTO;
import top.primsnet.sync.business.datasource.to.GetDataSourceFieldsTO;

import java.util.List;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 18:59
 **/
public interface DataSourceService {

    /**
     * 创建数据源的动态加载json
     * @param dataSourceStrTO 请求体
     * @return json字符串
     */
    String createDataSourceStr(CreateDataSourceStrTO dataSourceStrTO);

    /**
     * 加载数据源
     * @param beanName bean名称
     * @param configJsonStr 配置json字符串
     * 由{@code createDataSourceStr}方法构建
     */
    void initDataSource(String beanName,String configJsonStr);

    /**
     * 卸载数据源
     * @param beanName bean名称
     */
    void logoutDataSource(String beanName);

    /**
     * 获取数据源字段
     * @param beanName 数据源
     * @param tableName 表明
     * @return 字段集合
     */
    List<GetDataSourceFieldsTO> getFields(String beanName,String tableName);
}
