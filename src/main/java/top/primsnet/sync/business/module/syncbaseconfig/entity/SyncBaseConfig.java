package top.primsnet.sync.business.module.syncbaseconfig.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
@ApiModel(value = "SyncBaseConfig对象", description = "同步配置-基础配置、数据源关联关系")
public class SyncBaseConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("type")
    private String type;

    @TableField("from_id")
    private Integer fromId;

    @TableField("to_id")
    private Integer toId;

    @TableField("status")
    private Integer status;
}
