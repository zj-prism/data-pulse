package top.prism.sync.business.module.synctableconfig.controller;

import top.prism.sync.business.module.synctableconfig.service.SyncTableConfigService;
import top.prism.sync.business.module.synctableconfig.vo.SyncTableConfigReqVO;
import top.prism.sync.business.module.synctableconfig.vo.SyncTableConfigResVO;
import top.prism.sync.common.mybatis.base.PageResult;
import top.prism.sync.common.result.Result;

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
 * @since 2024-12-27 14:02:16
 */

@Api(tags = "synctableconfig")
@Controller
@Mapping("/synctableconfig")
public class SyncTableConfigController {


    @Inject
    private SyncTableConfigService syncTableConfigService;

    @Mapping(value = "page",method = MethodType.GET)
    @ApiOperation("分页")
    public Result<PageResult<SyncTableConfigResVO>> page(SyncTableConfigReqVO reqVO){
        return Result.ok(syncTableConfigService.page(reqVO));
    }

    @Mapping(value = "list",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<SyncTableConfigResVO>> list(SyncTableConfigReqVO reqVO){
        return Result.ok(syncTableConfigService.list(reqVO));
    }

    @Mapping(value = "detail",method = MethodType.GET)
    @ApiOperation("详情")
    public Result<SyncTableConfigResVO> detail(Integer id){
        return Result.ok(syncTableConfigService.detail(id));
    }

    @Mapping(value = "add",method = MethodType.POST)
    @ApiOperation("新增")
    public Result<String> add(SyncTableConfigReqVO reqVO){
        syncTableConfigService.add(reqVO);
        return Result.ok();
    }
    @Mapping(value = "edit",method = MethodType.POST)
    @ApiOperation("编辑")
    public Result<String> edit(SyncTableConfigReqVO reqVO){
        syncTableConfigService.edit(reqVO);
        return Result.ok();
    }

    @Mapping(value = "delete",method = MethodType.GET)
    @ApiOperation("删除")
    public Result<String> delete(Integer id){
        syncTableConfigService.delete(id);
        return Result.ok();
    }
}
