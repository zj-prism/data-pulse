package top.primsnet.sync.business.datasource.service;

import cn.hutool.core.util.ObjectUtil;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Init;
import top.primsnet.sync.common.exception.ServiceException;
import top.primsnet.sync.datapush.to.service.DataConsumerService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: joshua
 * @Description: TODO
 * @DateTime: 2024/8/8 19:41
 **/
@Component
public class DataSourceServiceContext {


    private static Map<String, DataSourceService> map = new HashMap<>();


    @Init
    public void init() {
        map = Solon.context().getBeansMapOfType(DataSourceService.class);
    }


    /**
     * 通过类型获取具体实现
     * @param type 实现bean类型
     * @return 具体实现的父类
     */
    public DataSourceService getService(String type){
        DataSourceService classImpl = map.get(type);
        if (ObjectUtil.isNull(classImpl)){
            throw new ServiceException("该数据处理模型未实现");
        }
        return classImpl;
    }

}
