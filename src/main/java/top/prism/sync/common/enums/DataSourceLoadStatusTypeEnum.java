package top.prism.sync.common.enums;

import lombok.Getter;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 19:26
 **/
@Getter
public enum DataSourceLoadStatusTypeEnum {

    LOADING("已装载",1),
    NOLOADING("未装载",0)

    ;

    private final String remark;
    private final Integer value;

    DataSourceLoadStatusTypeEnum(String remark, Integer value) {
        this.remark = remark;
        this.value = value;
    }


}
