package top.prism.sync.common.enums;

import lombok.Getter;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 19:26
 **/
@Getter
public enum DataSourceMapperTypeEnum {

    MYSQL("MysqlDataSourceMapper",1),
    ES("ElasticSearchDataSourceMapper",2)

    ;

    //具体数据源实现类
    private final String remark;
    //对应数据源配置表中的类型
    private final Integer value;

    DataSourceMapperTypeEnum(String remark, Integer value) {
        this.remark = remark;
        this.value = value;
    }

    /**
     * 根据数据表中的类型获取枚举
     * @param value 类型
     * @return 对应枚举
     */
    public static DataSourceMapperTypeEnum getByValue(Integer value) {
        for (DataSourceMapperTypeEnum dataSourceTypeEnum : DataSourceMapperTypeEnum.values()) {
            if (dataSourceTypeEnum.getValue().equals(value)) {
                return dataSourceTypeEnum;
            }
        }
        return null;
    }

}
