package ${package.Service};

import ${package.Entity}.${entity};
import ${package.Parent}.vo.${entity}ReqVO;
import ${package.Parent}.vo.${entity}ResVO;
import java.util.List;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.mybatis.base.BaseService;
/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends BaseService<${entity}> {
    PageResult<${entity}ResVO> page(${entity}ReqVO reqVO);
    List<${entity}ResVO> list(${entity}ReqVO reqVO);
    ${entity}ResVO detail(Integer id);
    void add(${entity}ReqVO reqVO);
    void edit(${entity}ReqVO reqVO);
    void delete(Integer id);
}
</#if>
