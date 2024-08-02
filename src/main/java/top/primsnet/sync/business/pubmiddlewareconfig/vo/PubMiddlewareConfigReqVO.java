package top.primsnet.sync.business.pubmiddlewareconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.primsnet.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * @author joshua
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
