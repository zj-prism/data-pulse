package top.primsnet.sync.business.pubdatasourceconfig.controller;

import top.primsnet.sync.business.pubdatasourceconfig.service.PubDataSourceConfigService;
import top.primsnet.sync.business.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.primsnet.sync.business.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
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
 * @since 2024-07-30 14:30:12
 */

@Api(tags = "pubdatasourceconfig")
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
}
