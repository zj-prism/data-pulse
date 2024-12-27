package top.primsnet.sync.common.enums;

import lombok.Getter;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 19:26
 **/
@Getter
public enum PublicStatusTypeEnum {

    OPEN("开启",1),
    CLOSE("关闭",0)

    ;

    private final String remark;
    private final Integer value;

    PublicStatusTypeEnum(String remark, Integer value) {
        this.remark = remark;
        this.value = value;
    }


}
