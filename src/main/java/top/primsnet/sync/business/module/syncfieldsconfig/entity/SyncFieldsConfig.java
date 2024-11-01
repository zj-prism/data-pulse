package top.primsnet.sync.business.module.syncfieldsconfig.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author joshua
 * @since 2024-11-01 17:41:40
 */
@Getter
@Setter
@TableName("sync_fields_config")
@ApiModel(value = "SyncFieldsConfig对象", description = "")
public class SyncFieldsConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("base_id")
    private Integer baseId;

    @TableField("from_field")
    private String fromField;

    @TableField("to_field")
    private String toField;

    @TableField("field_type")
    private String fieldType;

    @TableField("trans_type")
    private String transType;
}
