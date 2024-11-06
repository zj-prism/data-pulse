package top.primsnet.sync.business.module.syncfieldsconfig.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
* <p>
    * 
    * </p>
*
* Author joshua
* @since 2024-11-01 17:41:40
*/

@Data
@ApiModel(value = "SyncFieldsConfigResVO")
public class SyncFieldsConfigResVO {

    //ID
    private Integer id;

    //基础配置ID
    private Integer baseId;

    //来源字段
    private String fromField;

    //目标字段
    private String toField;

    //字段类型
    private String fieldType;

    //转换类型
    private String transType;

}
