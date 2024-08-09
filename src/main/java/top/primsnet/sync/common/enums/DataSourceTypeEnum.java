package top.primsnet.sync.common.enums;

import lombok.Getter;

/**
 * @Author: joshua
 * @Description: TODO
 * @DateTime: 2024/8/8 19:26
 **/
@Getter
public enum DataSourceTypeEnum {

    MYSQL("MysqlDataSourceServiceImpl",1);


    private final String remark;
    private final Integer value;

    DataSourceTypeEnum(String remark,Integer value) {
        this.remark = remark;
        this.value = value;
    }

    public static DataSourceTypeEnum getByValue(Integer value) {
        for (DataSourceTypeEnum dataSourceTypeEnum : DataSourceTypeEnum.values()) {
            if (dataSourceTypeEnum.getValue().equals(value)) {
                return dataSourceTypeEnum;
            }
        }
        return null;
    }

}
