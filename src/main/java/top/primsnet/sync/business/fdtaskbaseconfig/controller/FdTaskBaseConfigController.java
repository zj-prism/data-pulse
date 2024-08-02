package top.primsnet.sync.business.fdtaskbaseconfig.controller;

import top.primsnet.sync.business.fdtaskbaseconfig.service.FdTaskBaseConfigService;
import top.primsnet.sync.business.fdtaskbaseconfig.vo.FdTaskBaseConfigReqVO;
import top.primsnet.sync.business.fdtaskbaseconfig.vo.FdTaskBaseConfigResVO;
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
 * @author joshua
 * @since 2024-07-18
 */

@Api(tags = "fdtaskbaseconfig")
@Controller
@Mapping("/fdtaskbaseconfig")
public class FdTaskBaseConfigController {


    @Inject
    private FdTaskBaseConfigService fdTaskBaseConfigService;

    @Mapping(value = "page",method = MethodType.GET)
    @ApiOperation("分页")
    public Result<PageResult<FdTaskBaseConfigResVO>> page(FdTaskBaseConfigReqVO reqVO){
        return Result.ok(fdTaskBaseConfigService.page(reqVO));
    }

    @Mapping(value = "list",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<FdTaskBaseConfigResVO>> list(FdTaskBaseConfigReqVO reqVO){
        return Result.ok(fdTaskBaseConfigService.list(reqVO));
    }

    @Mapping(value = "detail",method = MethodType.GET)
    @ApiOperation("详情")
    public Result<FdTaskBaseConfigResVO> detail(Integer id){
        return Result.ok(fdTaskBaseConfigService.detail(id));
    }

    @Mapping(value = "add",method = MethodType.POST)
    @ApiOperation("新增")
    public Result<String> add(FdTaskBaseConfigReqVO reqVO){
        fdTaskBaseConfigService.add(reqVO);
        return Result.ok();
    }
    @Mapping(value = "edit",method = MethodType.POST)
    @ApiOperation("编辑")
    public Result<String> edit(FdTaskBaseConfigReqVO reqVO){
        fdTaskBaseConfigService.edit(reqVO);
        return Result.ok();
    }

    @Mapping(value = "delete",method = MethodType.GET)
    @ApiOperation("删除")
    public Result<String> delete(Integer id){
        fdTaskBaseConfigService.delete(id);
        return Result.ok();
    }
}
