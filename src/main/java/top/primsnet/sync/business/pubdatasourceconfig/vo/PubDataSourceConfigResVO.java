package top.primsnet.sync.business.pubdatasourceconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;

/**
* <p>
    * 
    * </p>
*
* @author joshua
* @since 2024-07-23 22:20:29
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

}
