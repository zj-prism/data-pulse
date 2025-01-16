package top.prism.sync.business.module.pubmiddlewareconfig.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;

/**
* <p>
    * 
    * </p>
*
* Author joshua
* @since 2024-08-02 09:34:40
*/

@Data
@ApiModel(value = "PubMiddlewareConfigResVO")
public class PubMiddlewareConfigResVO {

    private Integer id;

    private Integer name;

    private Integer type;

    private Integer url;

    private Integer userName;

    private Integer password;

    private Integer extend;

}
