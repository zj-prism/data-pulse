package top.primsnet.sync.business.module.syncfieldsconfig.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.MethodType;
import top.primsnet.sync.business.module.syncfieldsconfig.service.SyncFieldsConfigService;
import top.primsnet.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigReqVO;
import top.primsnet.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigResVO;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.result.Result;

import java.util.List;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:41:40
 */

@Api(tags = "同步任务字段配置")
@Controller
@Mapping("/syncfieldsconfig")
public class SyncFieldsConfigController {


    @Inject
    private SyncFieldsConfigService syncFieldsConfigService;

    @Mapping(value = "page",method = MethodType.GET)
    @ApiOperation("分页")
    public Result<PageResult<SyncFieldsConfigResVO>> page(SyncFieldsConfigReqVO reqVO){
        return Result.ok(syncFieldsConfigService.page(reqVO));
    }

    @Mapping(value = "list",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<SyncFieldsConfigResVO>> list(SyncFieldsConfigReqVO reqVO){
        return Result.ok(syncFieldsConfigService.list(reqVO));
    }

    @Mapping(value = "detail",method = MethodType.GET)
    @ApiOperation("详情")
    public Result<SyncFieldsConfigResVO> detail(Integer id){
        return Result.ok(syncFieldsConfigService.detail(id));
    }

    @Mapping(value = "add",method = MethodType.POST)
    @ApiOperation("新增")
    public Result<String> add(SyncFieldsConfigReqVO reqVO){
        syncFieldsConfigService.add(reqVO);
        return Result.ok();
    }
    @Mapping(value = "edit",method = MethodType.POST)
    @ApiOperation("编辑")
    public Result<String> edit(SyncFieldsConfigReqVO reqVO){
        syncFieldsConfigService.edit(reqVO);
        return Result.ok();
    }

    @Mapping(value = "delete",method = MethodType.GET)
    @ApiOperation("删除")
    public Result<String> delete(Integer id){
        syncFieldsConfigService.delete(id);
        return Result.ok();
    }
}
