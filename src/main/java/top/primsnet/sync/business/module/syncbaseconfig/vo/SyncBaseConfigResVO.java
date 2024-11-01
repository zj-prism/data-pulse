package top.primsnet.sync.business.module.syncbaseconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;

/**
* <p>
    * 
    * </p>
*
* Author joshua
* @since 2024-11-01 17:40:38
*/

@Data
@ApiModel(value = "SyncBaseConfigResVO")
public class SyncBaseConfigResVO {

    private Integer id;

    private String name;

    private Integer fromId;

    private Integer toId;

    private Integer status;

}
