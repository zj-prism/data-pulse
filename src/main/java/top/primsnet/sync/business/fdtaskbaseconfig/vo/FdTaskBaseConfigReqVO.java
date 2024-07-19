package top.primsnet.sync.business.fdtaskbaseconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.primsnet.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * @author joshua
 * @since 2024-07-18
 */

@Data
@ApiModel(value = "FdTaskBaseConfigReqVO")
public class FdTaskBaseConfigReqVO extends BaseQuery {

    private Integer id;

    private String name;

    private Integer dataFromType;

    private Integer dataFromDbId;

    private Integer dataToType;

    private Integer dataToDbId;

    private Integer status;

}
