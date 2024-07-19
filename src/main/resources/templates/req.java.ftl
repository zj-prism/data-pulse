package ${package.Parent}.vo;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import top.primsnet.sync.common.mybatis.base.BaseQuery;

/**
 * <p>
 * ${table.comment!}
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Data
@ApiModel(value = "${entity}ReqVO")
public class ${entity}ReqVO extends BaseQuery {
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>

    <#if field.comment!?length gt 0>
        <#if springdoc>
    @Schema(description = "${field.comment}")
        <#elseif swagger>
    @ApiModelProperty("${field.comment}")
        <#else>
    /**
     * ${field.comment}
     */
        </#if>
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>

}
