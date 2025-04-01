package top.prism.sync.business.sync.from.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import top.prism.sync.business.sync.from.service.DataSyncService;
@Slf4j

@Component("MysqlDataSyncImpl")
public class MysqlDataSyncImpl implements DataSyncService {


    /**
     * 数据监听
     *
     * @param syncConfigId 数据同步配置id
     */
    @Override
    public void createDataListener(Integer syncConfigId) {

    }
}
