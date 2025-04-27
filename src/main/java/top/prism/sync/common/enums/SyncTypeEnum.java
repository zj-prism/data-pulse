package top.prism.sync.common.enums;

import lombok.Getter;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 19:26
 **/
@Getter
public enum SyncTypeEnum {

    BATCH("批量","1"),
    TIMEING("实时","2")

    ;

    private final String remark;
    private final String value;

    SyncTypeEnum(String remark, String value) {
        this.remark = remark;
        this.value = value;
    }


}
