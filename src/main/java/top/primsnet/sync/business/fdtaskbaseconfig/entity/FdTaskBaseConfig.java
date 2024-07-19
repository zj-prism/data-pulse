package top.primsnet.sync.business.fdtaskbaseconfig.entity;

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
 * @since 2024-07-18
 */
@Getter
@Setter
@TableName("fd_task_base_config")
@ApiModel(value = "FdTaskBaseConfig对象", description = "")
public class FdTaskBaseConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("data_from_type")
    private Integer dataFromType;

    @TableField("data_from_db_id")
    private Integer dataFromDbId;

    @TableField("data_to_type")
    private Integer dataToType;

    @TableField("data_to_db_id")
    private Integer dataToDbId;

    @TableField("status")
    private Integer status;
}
