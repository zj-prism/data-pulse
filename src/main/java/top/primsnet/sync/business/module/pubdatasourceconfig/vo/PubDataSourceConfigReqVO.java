package top.primsnet.sync.business.module.pubdatasourceconfig.vo;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.primsnet.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * @author joshua
 * @since 2024-07-30 14:30:12
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

    private String configJsonStr;

    private String loadStatus;

}
