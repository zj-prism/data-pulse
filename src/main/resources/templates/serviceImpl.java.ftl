package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Service}.${entity}Service;
import ${package.Parent}.vo.${entity}ReqVO;
import ${package.Parent}.vo.${entity}ResVO;
import ${package.Parent}.convert.${entity}Convert;
import ${package.Parent}.mapper.${entity}Mapper;
import cn.hutool.core.util.ObjUtil;
import top.primsnet.sync.common.mybatis.base.BaseServiceImpl;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.mybatis.page.PageProcess;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Component;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * Author ${author}
 * @since ${date}
 */
@Component
public class ${table.serviceImplName} extends BaseServiceImpl<${entity}Mapper, ${entity}> implements ${entity}Service {
    @Override
    @ApiOperation("分页")
    public PageResult<${entity}ResVO> page(${entity}ReqVO reqVO) {
       return PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
    }

    @Override
    @ApiOperation("列表")
    public List<${entity}ResVO> list(${entity}ReqVO reqVO) {
       return ${entity}Convert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
    }

     @Override
     @ApiOperation("详情")
     public ${entity}ResVO detail(Integer id) {
        return ${entity}Convert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(${entity}ReqVO reqVO) {
        ${entity} entity = ${entity}Convert.INSTANCE.convert(reqVO);
        save(entity);
     }

     @Override
     @ApiOperation("编辑")
     public void edit(${entity}ReqVO reqVO) {
        ${entity} entity = ${entity}Convert.INSTANCE.convert(reqVO);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }


     private QueryWrapper<${entity}> getQueryWrapper(${entity}ReqVO reqVO) {
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){

        }
        return queryWrapper;
    }
}

