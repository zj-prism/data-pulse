package ${package.Controller};

import ${package.Service}.${entity}Service;
import ${package.Parent}.vo.${entity}ReqVO;
import ${package.Parent}.vo.${entity}ResVO;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.result.Result;
import java.util.ArrayList;
import java.util.List;
import org.noear.solon.core.handle.MethodType;
import org.noear.solon.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

@Api(tags = "${package.ModuleName}")
@Controller
@Mapping("/${package.ModuleName}")
public class ${entity}Controller {


    @Inject
    private ${entity}Service ${Entity}Service;

    @Mapping(value = "page",method = MethodType.GET)
    @ApiOperation("分页")
    public Result<PageResult<${entity}ResVO>> page(${entity}ReqVO reqVO){
        return Result.ok(${Entity}Service.page(reqVO));
    }

    @Mapping(value = "list",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<${entity}ResVO>> list(${entity}ReqVO reqVO){
        return Result.ok(${Entity}Service.list(reqVO));
    }

    @Mapping(value = "detail",method = MethodType.GET)
    @ApiOperation("详情")
    public Result<${entity}ResVO> detail(Integer id){
        return Result.ok(${Entity}Service.detail(id));
    }

    @Mapping(value = "add",method = MethodType.POST)
    @ApiOperation("新增")
    public Result<String> add(${entity}ReqVO reqVO){
        ${Entity}Service.add(reqVO);
        return Result.ok();
    }
    @Mapping(value = "edit",method = MethodType.POST)
    @ApiOperation("编辑")
    public Result<String> edit(${entity}ReqVO reqVO){
        ${Entity}Service.edit(reqVO);
        return Result.ok();
    }

    @Mapping(value = "delete",method = MethodType.GET)
    @ApiOperation("删除")
    public Result<String> delete(Integer id){
        ${Entity}Service.delete(id);
        return Result.ok();
    }
}
