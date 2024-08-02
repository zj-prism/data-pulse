package top.primsnet.sync.business.fdtaskbaseconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;

/**
* <p>
    * 
    * </p>
*
* @author joshua
* @since 2024-07-18
*/

@Data
@ApiModel(value = "FdTaskBaseConfigResVO")
public class FdTaskBaseConfigResVO {

    private Integer id;

    private String name;

    private Integer dataFromType;

    private Integer dataFromDbId;

    private Integer dataToType;

    private Integer dataToDbId;

    private Integer status;

}
