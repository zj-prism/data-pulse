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

    //ID
    private Integer id;

    //名称
    private String name;

    //类型
    private String type;

    //来源
    private Integer fromId;

    //目标
    private Integer toId;

    //状态
    private Integer status;

}
