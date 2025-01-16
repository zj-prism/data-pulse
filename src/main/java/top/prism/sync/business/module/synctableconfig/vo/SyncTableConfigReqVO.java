package top.prism.sync.business.module.synctableconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.prism.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * Author joshua
 * @since 2024-12-27 14:02:16
 */

@Data
@ApiModel(value = "SyncTableConfigReqVO")
public class SyncTableConfigReqVO extends BaseQuery {

    private Integer id;

    private Integer baseId;

    private Integer syncType;

    private String fromTable;

    private String toTable;

}
