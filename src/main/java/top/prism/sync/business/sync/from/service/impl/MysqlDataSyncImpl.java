package top.prism.sync.business.sync.from.service.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.gitee.Jmysy.binlog4j.core.*;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import top.prism.sync.business.module.pubdatasourceconfig.entity.PubDataSourceConfig;
import top.prism.sync.business.module.pubdatasourceconfig.service.PubDataSourceConfigService;
import top.prism.sync.business.module.syncbaseconfig.entity.SyncBaseConfig;
import top.prism.sync.business.module.syncbaseconfig.service.SyncBaseConfigService;
import top.prism.sync.business.sync.from.service.DataSyncService;
import top.prism.sync.common.enums.SyncTypeEnum;
import top.prism.sync.common.exception.ServiceException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j

@Component("MysqlDataSyncImpl")
public class MysqlDataSyncImpl implements DataSyncService {

    @Inject
    SyncBaseConfigService syncBaseConfigService;

    @Inject
    PubDataSourceConfigService pubDataSourceConfigService;

    /**
     * 数据监听
     *
     * @param syncConfigId 数据同步配置id
     */
    @Override
    public void createDataListener(Integer syncConfigId) {
        if (ObjUtil.isEmpty(syncConfigId)){
            throw new ServiceException("数据同步配置id不能为空");
        }
        //查询参数并开始组装数据
        SyncBaseConfig baseConfig = syncBaseConfigService.getById(syncConfigId);
        String type = baseConfig.getType();
        if (StrUtil.equals(type, SyncTypeEnum.BATCH.getValue())){
            throw new ServiceException("批量同步暂不支持");
        }
        //来源数据库
        Integer fromId = baseConfig.getFromId();
        PubDataSourceConfig fromDataSource = pubDataSourceConfigService.getById(fromId);
        if (ObjUtil.isEmpty(fromDataSource)){
            throw new ServiceException("来源数据库不存在");
        }
        //解析端口号
        String url = fromDataSource.getUrl();
        String host = "";
        int portPart = 3306;

        // 使用正则表达式提取主机名和端口号
        Pattern pattern = Pattern.compile("jdbc:mysql://([^:]+)(?::(\\d+))?/[^/]+");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            host = matcher.group(1);
            if (matcher.group(2) != null) {
                portPart = Integer.parseInt(matcher.group(2));
            }
        }
        BinlogClientConfig clientConfig = new BinlogClientConfig();
        clientConfig.setHost(host);
        clientConfig.setPort(portPart);
        clientConfig.setUsername(fromDataSource.getUserName());
        clientConfig.setPassword(fromDataSource.getPassword());
        clientConfig.setServerId(syncConfigId);
//        RedisConfig redisConfig = new RedisConfig();
//        redisConfig.setHost("127.0.0.1");
//        redisConfig.setPort(6379);
//        redisConfig.setPassword("123456");
//        redisConfig.setDatabase(2);
//        clientConfig.setRedisConfig(redisConfig);
//        clientConfig.setPersistence(true);
        IBinlogClient binlogClient = new BinlogClient(clientConfig);
        //设置监听类
        binlogClient.registerEventHandler(new IBinlogEventHandler() {
            /**
             * @param binlogEvent
             */
            @Override
            public void onInsert(BinlogEvent binlogEvent) {
                log.info("新增：{}", JSONUtil.toJsonStr(binlogEvent.getData()));
            }

            /**
             * @param binlogEvent
             */
            @Override
            public void onUpdate(BinlogEvent binlogEvent) {
                log.info("修改：{}", JSONUtil.toJsonStr(binlogEvent.getData()));
            }

            /**
             * @param binlogEvent
             */
            @Override
            public void onDelete(BinlogEvent binlogEvent) {
                log.info("删除：{}", JSONUtil.toJsonStr(binlogEvent.getData()));
            }

            /**
             * @param s
             * @param s1
             * @return
             */
            @Override
            public boolean isHandle(String s, String s1) {
                return true;
            }
        });
        binlogClient.connect();
    }
}
