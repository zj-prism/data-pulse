package top.primsnet.sync.business.module.pubdatasourceconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;

/**
* <p>
    * 
    * </p>
*
* Author joshua
* @since 2024-07-30 14:30:12
*/

@Data
@ApiModel(value = "PubDataSourceConfigResVO")
public class PubDataSourceConfigResVO {

    private Integer id;

    private String name;

    private Integer type;

    private String url;

    private String userName;

    private String password;

    private Integer loadStatus;

}
