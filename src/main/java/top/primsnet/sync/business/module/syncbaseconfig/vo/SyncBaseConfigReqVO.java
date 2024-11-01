package top.primsnet.sync.business.module.syncbaseconfig.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import top.primsnet.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:40:38
 */

@Data
@ApiModel(value = "SyncBaseConfigReqVO")
public class SyncBaseConfigReqVO extends BaseQuery {

    private Integer id;

    private String name;

    private String type;

    private Integer fromId;

    private Integer toId;

    private Integer status;

}
