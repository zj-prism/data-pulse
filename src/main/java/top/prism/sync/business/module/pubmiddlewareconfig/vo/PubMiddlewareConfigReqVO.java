package top.prism.sync.business.module.pubmiddlewareconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.prism.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * Author joshua
 * @since 2024-08-02 09:34:40
 */

@Data
@ApiModel(value = "PubMiddlewareConfigReqVO")
public class PubMiddlewareConfigReqVO extends BaseQuery {

    private Integer id;

    private Integer name;

    private Integer type;

    private Integer url;

    private Integer userName;

    private Integer password;

    private Integer extend;

}
