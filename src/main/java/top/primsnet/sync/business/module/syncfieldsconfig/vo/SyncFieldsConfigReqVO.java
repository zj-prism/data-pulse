package top.primsnet.sync.business.module.syncfieldsconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.primsnet.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:41:40
 */

@Data
@ApiModel(value = "SyncFieldsConfigReqVO")
public class SyncFieldsConfigReqVO extends BaseQuery {

    private Integer id;

    private Integer baseId;

    private String fromField;

    private String toField;

    private String fieldType;

    private String transType;

}
