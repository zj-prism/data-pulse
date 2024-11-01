package top.primsnet.sync.business.module.syncbaseconfig.entity;

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
 * @since 2024-11-01 17:40:38
 */
@Getter
@Setter
@TableName("sync_base_config")
@ApiModel(value = "SyncBaseConfig对象", description = "")
public class SyncBaseConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("from_id")
    private Integer fromId;

    @TableField("to_id")
    private Integer toId;

    @TableField("status")
    private Integer status;
}
