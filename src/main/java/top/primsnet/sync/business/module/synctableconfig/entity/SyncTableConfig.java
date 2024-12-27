package top.primsnet.sync.business.module.synctableconfig.entity;

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
 * @since 2024-12-27 14:02:16
 */
@Getter
@Setter
@TableName("sync_table_config")
@ApiModel(value = "SyncTableConfig对象", description = "")
public class SyncTableConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    @TableField("base_id")
    private Integer baseId;

    @TableField("from_table")
    private String fromTable;

    @TableField("to_table")
    private String toTable;
}
