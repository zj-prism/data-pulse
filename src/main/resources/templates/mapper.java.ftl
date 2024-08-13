package ${package.Mapper};

import org.apache.ibatis.annotations.Mapper;
import top.primsnet.sync.common.mybatis.MyBaseMapper;
import ${package.Entity}.${entity};

/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * Author ${author}
 * @since ${date}
 */
@Mapper
<#if mapperAnnotationClass??>
@${mapperAnnotationClass.simpleName}
</#if>
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends MyBaseMapper<${entity}> {

}
</#if>
