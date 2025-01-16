package top.prism.sync.common.enums;

import lombok.Getter;
import top.prism.sync.common.exception.ServiceException;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 19:26
 **/
@Getter
public enum DataSourceTypeEnum {

    MYSQL("MysqlDataSourceServiceImpl",1),
    ES("ElasticSearchDataSourceServiceImpl",2)

    ;

    //具体数据源实现类
    private final String remark;
    //对应数据源配置表中的类型
    private final Integer value;

    DataSourceTypeEnum(String remark,Integer value) {
        this.remark = remark;
        this.value = value;
    }

    /**
     * 根据数据表中的类型获取枚举
     * @param value 类型
     * @return 对应枚举
     */
    public static DataSourceTypeEnum getByValue(Integer value) {
        for (DataSourceTypeEnum dataSourceTypeEnum : DataSourceTypeEnum.values()) {
            if (dataSourceTypeEnum.getValue().equals(value)) {
                return dataSourceTypeEnum;
            }
        }
        throw new ServiceException("该类型数据源未实现");
    }

}
