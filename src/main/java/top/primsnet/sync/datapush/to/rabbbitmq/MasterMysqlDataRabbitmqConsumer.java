package top.primsnet.sync.datapush.to.rabbbitmq;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Inject;
import org.noear.solon.cloud.CloudEventHandler;
import org.noear.solon.cloud.annotation.CloudEvent;
import org.noear.solon.cloud.model.Event;
import top.primsnet.sync.datapush.to.service.DataConsumerHandler;
import top.primsnet.sync.datapush.from.listener.master.to.OrderTO;

@CloudEvent(topic="master.mysql", group = "mysqlOrder2es")
@Slf4j
public class MasterMysqlDataRabbitmqConsumer implements CloudEventHandler {

    @Inject
    private DataConsumerHandler dataConsumerHandler;

    /**
     * rabbitmq消费端
     * @param event 消息
     * @return 是否ack
     */
    @Override
    public boolean handle(Event event) {
        String content = event.content();
        String group = event.group();
        try {
            if (StrUtil.isNotBlank(content)){
                OrderTO orderTO = JSON.parseObject(content, OrderTO.class);
                dataConsumerHandler.getService(group).consume(orderTO);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
