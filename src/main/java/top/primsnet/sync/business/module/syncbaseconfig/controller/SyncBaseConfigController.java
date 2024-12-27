package top.primsnet.sync.business.module.syncbaseconfig.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Path;
import org.noear.solon.core.handle.MethodType;
import top.primsnet.sync.business.module.syncbaseconfig.service.SyncBaseConfigService;
import top.primsnet.sync.business.module.syncbaseconfig.vo.DataSourcesListResVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.FieldBindReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigResVO;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.result.Result;

import java.util.List;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:40:38
 */

@Api(tags = "同步任务基础配置")
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

    @Mapping(value = "fieldBind/{id}",method = MethodType.POST)
    @ApiOperation("字段绑定")
    public Result<String> fieldBind(@Path("id")Integer id, List<FieldBindReqVO> reqVOs){
        syncBaseConfigService.fieldBind(id,reqVOs);
        return Result.ok();
    }

    @Mapping(value = "getDataSourcesList",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<DataSourcesListResVO>> getDataSourcesList(){
        return Result.ok(syncBaseConfigService.getDataSourcesList());
    }

    @Mapping(value = "loadDataSource/{id}",method = MethodType.GET)
    @ApiOperation("加载数据源")
    public Result<String> loadDataSource(@Path("id") Integer id){
        syncBaseConfigService.loadDataSource(id);
        return Result.ok();
    }

    @Mapping(value = "unloadDataSource/{id}",method = MethodType.GET)
    @ApiOperation("卸载数据源")
    public Result<String> unloadDataSource(@Path("id") Integer id){
        syncBaseConfigService.unloadDataSource(id);
        return Result.ok();
    }
}
