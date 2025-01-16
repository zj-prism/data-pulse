package top.prism.sync.business.module.pubdatasourceconfig.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Path;
import org.noear.solon.core.handle.MethodType;
import top.prism.sync.business.datasource.to.GetDataSourceFieldsTO;
import top.prism.sync.business.module.pubdatasourceconfig.service.PubDataSourceConfigService;
import top.prism.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.prism.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import top.prism.sync.common.mybatis.base.PageResult;
import top.prism.sync.common.result.Result;

import java.util.List;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * Author joshua
 * @since 2024-07-30 14:30:12
 */

@Api(tags = "数据源配置")
@Controller
@Mapping("/pubdatasourceconfig")
public class PubDataSourceConfigController {


    @Inject
    private PubDataSourceConfigService pubDataSourceConfigService;

    @Mapping(value = "page",method = MethodType.GET)
    @ApiOperation("分页")
    public Result<PageResult<PubDataSourceConfigResVO>> page(PubDataSourceConfigReqVO reqVO){
        return Result.ok(pubDataSourceConfigService.page(reqVO));
    }

    @Mapping(value = "list",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<PubDataSourceConfigResVO>> list(PubDataSourceConfigReqVO reqVO){
        return Result.ok(pubDataSourceConfigService.list(reqVO));
    }

    @Mapping(value = "detail",method = MethodType.GET)
    @ApiOperation("详情")
    public Result<PubDataSourceConfigResVO> detail(Integer id){
        return Result.ok(pubDataSourceConfigService.detail(id));
    }

    @Mapping(value = "add",method = MethodType.POST)
    @ApiOperation("新增")
    public Result<String> add(PubDataSourceConfigReqVO reqVO){
        pubDataSourceConfigService.add(reqVO);
        return Result.ok();
    }
    @Mapping(value = "edit",method = MethodType.POST)
    @ApiOperation("编辑")
    public Result<String> edit(PubDataSourceConfigReqVO reqVO){
        pubDataSourceConfigService.edit(reqVO);
        return Result.ok();
    }

    @Mapping(value = "delete/{id}",method = MethodType.GET)
    @ApiOperation("删除")
    public Result<String> delete(@Path("id") Integer id){
        pubDataSourceConfigService.delete(id);
        return Result.ok();
    }

    @Mapping(value = "loadDataSource/{id}",method = MethodType.GET)
    @ApiOperation("加载数据源")
    public Result<String> loadDataSource(@Path("id") Integer id){
        pubDataSourceConfigService.loadDataSource(id);
        return Result.ok();
    }

    @Mapping(value = "unloadDataSource/{id}",method = MethodType.GET)
    @ApiOperation("卸载数据源")
    public Result<String> unloadDataSource(@Path("id") Integer id){
        pubDataSourceConfigService.unloadDataSource(id);
        return Result.ok();
    }

    @Mapping(value = "getFields/{id}",method = MethodType.GET)
    @ApiOperation("获取表字段")
    public Result<List<GetDataSourceFieldsTO>> getFields(@Path("id") Integer id,String tableName){
        List<GetDataSourceFieldsTO> list = pubDataSourceConfigService.getFields(id,tableName);
        return Result.ok(list);
    }
}
