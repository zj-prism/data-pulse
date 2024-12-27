package top.primsnet.sync.business.module.synctableconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;

/**
* <p>
    * 
    * </p>
*
* Author joshua
* @since 2024-12-27 14:02:16
*/

@Data
@ApiModel(value = "SyncTableConfigResVO")
public class SyncTableConfigResVO {

    private Integer id;

    private Integer baseId;

    private String fromTable;

    private String toTable;

}
