package top.prism.sync.business.sync.from.dto;

import lombok.Data;

@Data
public class MysqlSyncDataListenerTO {

    // 数据库地址
    private String url;

    //  数据库端口
    private Integer port;

    // 数据库用户名
    private String username;

    // 数据库密码
    private String password;

    //服务 ID
    private Long serverId;
}
