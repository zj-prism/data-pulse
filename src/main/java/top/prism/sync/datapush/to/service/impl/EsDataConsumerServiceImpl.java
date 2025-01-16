package top.prism.sync.datapush.to.service.impl;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.noear.esearchx.EsContext;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import top.prism.sync.common.exception.ServiceException;
import top.prism.sync.datapush.to.service.DataConsumerService;
import top.prism.sync.datapush.from.listener.master.to.OrderTO;

import java.io.IOException;

@Component("mysqlOrder2es")
@Slf4j
public class EsDataConsumerServiceImpl implements DataConsumerService {


    @Inject("${test.esx}")
    EsContext context;

    @Override
    public void consume(Object data) {
        if (ObjUtil.isEmpty(data)){
            throw new ServiceException("master.mysql 推送数据为空");
        }
        OrderTO orderTO = (OrderTO) data;
        log.info("master.mysql 推送数据为：{}", JSON.toJSONString(orderTO));
        try {
            String rst = context.indice("order_2024").upsert(orderTO.getId()+"", orderTO);
            log.info("消费数据成功：{}",rst);
        } catch (IOException e) {
            log.error("master.mysql 推送es失败，orderID:{},{}",orderTO.getId(), ExceptionUtil.stacktraceToString(e));
            throw new ServiceException("master.mysql 推送es失败");
        }
    }
}
