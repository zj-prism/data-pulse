package top.prism.sync.business.sync.from.service;

public interface DataSyncService {

    /**
     * 数据监听
     * @param syncConfigId 数据同步配置id
     */
    void createDataListener(Integer syncConfigId);

}
