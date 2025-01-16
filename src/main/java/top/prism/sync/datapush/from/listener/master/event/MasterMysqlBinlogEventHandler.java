package top.prism.sync.datapush.from.listener.master.event;

import com.alibaba.fastjson.JSON;
import com.gitee.Jmysy.binlog4j.core.BinlogEvent;
import com.gitee.Jmysy.binlog4j.core.IBinlogEventHandler;
import org.noear.solon.annotation.Component;
import org.noear.solon.cloud.CloudClient;
import org.noear.solon.cloud.model.Event;
import top.prism.sync.datapush.from.listener.master.to.OrderTO;

@Component
public class MasterMysqlBinlogEventHandler implements IBinlogEventHandler<OrderTO> {

    @Override
    public void onInsert(BinlogEvent<OrderTO> event) {
        Event mqevent = new Event("master.mysql", JSON.toJSONString(event.getData())).group("mysqlOrder2es");
        CloudClient.event().publish(mqevent);
    }

    @Override
    public void onUpdate(BinlogEvent<OrderTO> event) {
        Event mqevent = new Event("master.mysql", JSON.toJSONString(event.getData())).group("mysqlOrder2es");
        CloudClient.event().publish(mqevent);
    }

    @Override
    public void onDelete(BinlogEvent<OrderTO> event) {
        System.out.println("删除数据:" + event.getData());
    }

    @Override
    public boolean isHandle(String database, String table) {
        return database.equals("jinling") && table.equals("dd_order");
    }

}