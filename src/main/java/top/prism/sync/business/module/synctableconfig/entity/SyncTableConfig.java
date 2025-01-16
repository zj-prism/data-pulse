package top.prism.sync.business.module.synctableconfig.entity;

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
@ApiModel(value = "SyncTableConfig对象", description = "同步配置-表关联关系")
public class SyncTableConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Integer id;

    //基础配置ID
    @TableField("base_id")
    private Integer baseId;

    //同步类型 1-批量同步 2-实时同步
    @TableField("sync_type")
    private Integer syncType;

    //数据来源表
    @TableField("from_table")
    private String fromTable;

    //数据目的表
    @TableField("to_table")
    private String toTable;
}
