package top.primsnet.sync.business.module.sysuser.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;

/**
* <p>
    * 
    * </p>
*
* Author joshua
* @since 2024-11-01 17:56:23
*/

@Data
@ApiModel(value = "SysUserResVO")
public class SysUserResVO {

    private Integer id;

    private String desc;

    private String userName;

    private String password;

    private String status;

}
