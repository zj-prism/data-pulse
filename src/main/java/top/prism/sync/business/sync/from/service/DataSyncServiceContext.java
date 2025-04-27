package top.prism.sync.business.sync.from.service;

import cn.hutool.core.util.ObjectUtil;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Init;
import top.prism.sync.common.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 19:41
 **/
@Component
public class DataSyncServiceContext {


    private static Map<String, DataSyncService> map = new HashMap<>();


    @Init
    public void init() {
        map = Solon.context().getBeansMapOfType(DataSyncService.class);
    }


    /**
     * 通过类型获取具体实现
     * @param type 实现bean类型
     * @return 具体实现的父类
     */
    public DataSyncService getService(String type){
        DataSyncService classImpl = map.get(type);
        if (ObjectUtil.isNull(classImpl)){
            throw new ServiceException("该数据处理模型未实现");
        }
        return classImpl;
    }

}
