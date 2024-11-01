package top.primsnet.sync.business.module.syncbaseconfig.controller;

import top.primsnet.sync.business.module.syncbaseconfig.service.SyncBaseConfigService;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigResVO;
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
 * @since 2024-11-01 17:40:38
 */

@Api(tags = "syncbaseconfig")
@Controller
@Mapping("/syncbaseconfig")
public class SyncBaseConfigController {


    @Inject
    private SyncBaseConfigService syncBaseConfigService;

    @Mapping(value = "page",method = MethodType.GET)
    @ApiOperation("分页")
    public Result<PageResult<SyncBaseConfigResVO>> page(SyncBaseConfigReqVO reqVO){
        return Result.ok(syncBaseConfigService.page(reqVO));
    }

    @Mapping(value = "list",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<SyncBaseConfigResVO>> list(SyncBaseConfigReqVO reqVO){
        return Result.ok(syncBaseConfigService.list(reqVO));
    }

    @Mapping(value = "detail",method = MethodType.GET)
    @ApiOperation("详情")
    public Result<SyncBaseConfigResVO> detail(Integer id){
        return Result.ok(syncBaseConfigService.detail(id));
    }

    @Mapping(value = "add",method = MethodType.POST)
    @ApiOperation("新增")
    public Result<String> add(SyncBaseConfigReqVO reqVO){
        syncBaseConfigService.add(reqVO);
        return Result.ok();
    }
    @Mapping(value = "edit",method = MethodType.POST)
    @ApiOperation("编辑")
    public Result<String> edit(SyncBaseConfigReqVO reqVO){
        syncBaseConfigService.edit(reqVO);
        return Result.ok();
    }

    @Mapping(value = "delete",method = MethodType.GET)
    @ApiOperation("删除")
    public Result<String> delete(Integer id){
        syncBaseConfigService.delete(id);
        return Result.ok();
    }
}
