package top.primsnet.sync.business.module.pubdatasourceconfig.entity;

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
 * @since 2024-07-30 14:30:12
 */
@Getter
@Setter
@TableName("pub_data_source_config")
@ApiModel(value = "PubDataSourceConfig对象", description = "")
public class PubDataSourceConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("type")
    private Integer type;

    @TableField("url")
    private String url;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("config_json_str")
    private String configJsonStr;

    @TableField("load_status")
    private Integer loadStatus;
}
