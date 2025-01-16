package top.prism.sync.business.module.pubmiddlewareconfig.entity;

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
 * Author joshua
 * @since 2024-08-02 09:34:40
 */
@Getter
@Setter
@TableName("pub_middleware_config")
@ApiModel(value = "PubMiddlewareConfig对象", description = "中间件配置")
public class PubMiddlewareConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private Integer name;

    @TableField("type")
    private Integer type;

    @TableField("url")
    private Integer url;

    @TableField("user_name")
    private Integer userName;

    @TableField("password")
    private Integer password;

    @TableField("extend")
    private Integer extend;
}
