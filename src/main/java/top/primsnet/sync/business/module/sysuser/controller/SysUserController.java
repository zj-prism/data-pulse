package top.primsnet.sync.business.module.sysuser.controller;

import top.primsnet.sync.business.module.sysuser.service.SysUserService;
import top.primsnet.sync.business.module.sysuser.vo.SysUserReqVO;
import top.primsnet.sync.business.module.sysuser.vo.SysUserResVO;
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
 * Author joshua
 * @since 2024-11-01 17:56:23
 */

@Api(tags = "sysuser")
@Controller
@Mapping("/sysuser")
public class SysUserController {


    @Inject
    private SysUserService sysUserService;

    @Mapping(value = "page",method = MethodType.GET)
    @ApiOperation("分页")
    public Result<PageResult<SysUserResVO>> page(SysUserReqVO reqVO){
        return Result.ok(sysUserService.page(reqVO));
    }

    @Mapping(value = "list",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<SysUserResVO>> list(SysUserReqVO reqVO){
        return Result.ok(sysUserService.list(reqVO));
    }

    @Mapping(value = "detail",method = MethodType.GET)
    @ApiOperation("详情")
    public Result<SysUserResVO> detail(Integer id){
        return Result.ok(sysUserService.detail(id));
    }

    @Mapping(value = "add",method = MethodType.POST)
    @ApiOperation("新增")
    public Result<String> add(SysUserReqVO reqVO){
        sysUserService.add(reqVO);
        return Result.ok();
    }
    @Mapping(value = "edit",method = MethodType.POST)
    @ApiOperation("编辑")
    public Result<String> edit(SysUserReqVO reqVO){
        sysUserService.edit(reqVO);
        return Result.ok();
    }

    @Mapping(value = "delete",method = MethodType.GET)
    @ApiOperation("删除")
    public Result<String> delete(Integer id){
        sysUserService.delete(id);
        return Result.ok();
    }
}
