package top.prism.sync.datapush.to.service;

public interface DataConsumerService {

    /**
     * 数据消费
     * @param data 数据
     */
    void consume(Object data);

}
