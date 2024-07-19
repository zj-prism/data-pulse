package top.primsnet.sync.datapush.to.service;

import cn.hutool.core.util.ObjectUtil;
import org.noear.solon.Solon;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Init;
import top.primsnet.sync.common.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

/**
 * 消费端消息处理模型策略模式
 */
@Component
public class DataConsumerHandler {

    private static Map<String, DataConsumerService> map = new HashMap<>();

    /**
     * 启动时将所有实现加载到容器
     */
    @Init
    public void setApplicationContext()  {
        map = Solon.context().getBeansMapOfType(DataConsumerService.class);
    }

    /**
     * 通过类型获取具体实现
     * @param type 实现bean类型
     * @return 具体实现的父类
     */
    public DataConsumerService getService(String type){
        DataConsumerService classImpl = map.get(type);
        if (ObjectUtil.isNull(classImpl)){
            throw new ServiceException("该数据处理模型未实现");
        }
        return classImpl;
    }


}
