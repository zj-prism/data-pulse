package top.primsnet.sync.datapush.from.listener.master.event;

import com.gitee.Jmysy.binlog4j.core.*;
import com.gitee.Jmysy.binlog4j.core.config.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Init;
import org.noear.solon.annotation.Inject;


//@Component
@Slf4j
public class MasterMysqlListener {

    @Inject("${from.one-mysql.host}")
    private String fromUrl;

    @Inject("${from.one-mysql.port}")
    private Integer fromPort;

    @Inject("${from.one-mysql.user}")
    private String fromUser;

    @Inject("${from.one-mysql.password}")
    private String fromPassword;

    @Inject("${from.one-mysql.serverId}")
    private Integer fromServerId;

    @Inject("${from.one-mysql.handle}")
    private String fromHandle;

    @Init
    public void onApplicationEvent() {
        //基础配置
        BinlogClientConfig clientConfig = new BinlogClientConfig();
        clientConfig.setHost(fromUrl);
        clientConfig.setPort(fromPort);
        clientConfig.setUsername(fromUser);
        clientConfig.setPassword(fromPassword);
        clientConfig.setServerId(fromServerId);
        RedisConfig redisConfig = new RedisConfig();
        redisConfig.setHost("127.0.0.1");
        redisConfig.setPort(6379);
        redisConfig.setPassword("123456");
        redisConfig.setDatabase(2);
        clientConfig.setRedisConfig(redisConfig);
        clientConfig.setPersistence(true);
        IBinlogClient binlogClient = new BinlogClient(clientConfig);
        //设置监听类
        binlogClient.registerEventHandler(new MasterMysqlBinlogEventHandler());
        binlogClient.connect();
    }
}
