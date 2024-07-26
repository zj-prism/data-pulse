package top.primsnet.sync.business.pubdatasourceconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.primsnet.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * @author joshua
 * @since 2024-07-23 22:20:29
 */

@Data
@ApiModel(value = "PubDataSourceConfigReqVO")
public class PubDataSourceConfigReqVO extends BaseQuery {

    private Integer id;

    private String name;

    private Integer type;

    private String url;

    private String userName;

    private String password;

}
