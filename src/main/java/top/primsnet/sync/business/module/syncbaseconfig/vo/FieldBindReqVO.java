package top.primsnet.sync.business.module.syncbaseconfig.vo;

import lombok.Data;

/**
 * Author:  joshua
 * Description: TODO
 * DateTime: 2024/11/6 21:52
 **/
@Data
public class FieldBindReqVO {

    //来源字段
    private String fromFieldName;

    //字段类型
    private String fromFieldType;

    //目标字段
    private String toFieldName;

    //字段类型
    private String toFieldType;

    //todo 转换类型   （规划   1-转字符串 2-转时间 3-转数字）
    private String transType;

}
