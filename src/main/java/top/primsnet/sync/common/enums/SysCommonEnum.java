package top.primsnet.sync.common.enums;

import lombok.Getter;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 19:20
 **/
@Getter
public enum SysCommonEnum {

    DATA_SOURCE_POOL_TYPE("数据库连接池类型","com.zaxxer.hikari.HikariDataSource"),
    DATA_SOURCE_STRICT_CLOSE_TYPE("数据源强制校验-开",false),
    DATA_SOURCE_STRICT_OPEN_TYPE("数据源强制校验-关",true),
    MYSQL_5_DRIVER_CLASS_NAME("mysql驱动5.x版本","com.mysql.jdbc.Driver"),
    MYSQL_8_DRIVER_CLASS_NAME("mysql驱动8.x版本","com.mysql.cj.jdbc.Driver"),
    DATA_SOURCE_LOAD_OPEN_TYPE("数据源加载状态-开",1),
    DATA_SOURCE_LOAD_CLOSE_TYPE("数据源加载状态-关",0),



    ;

    private final String remark;
    private final Object value;

   SysCommonEnum(String remark,Object value) {
       this.remark =remark;
       this.value = value;
   }
}
