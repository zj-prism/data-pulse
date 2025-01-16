package top.prism.sync.business.module.sysuser.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.prism.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * 
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:56:23
 */

@Data
@ApiModel(value = "SysUserReqVO")
public class SysUserReqVO extends BaseQuery {

    private Integer id;

    private String desc;

    private String userName;

    private String password;

    private String status;

}
