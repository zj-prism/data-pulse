package ${package.Parent}.convert;

import ${package.Entity}.${entity};
import ${package.Parent}.vo.${entity}ReqVO;
import ${package.Parent}.vo.${entity}ResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* @author ${author}
* @since ${date}
*/
@Mapper
public interface ${entity}Convert{

    ${entity}Convert INSTANCE = Mappers.getMapper(${entity}Convert.class);

    ${entity} convert(${entity}ReqVO reqVO);
    ${entity}ResVO convert(${entity} reqVO);
    List<${entity}ResVO> convert(List<${entity}> reqVO);
}



