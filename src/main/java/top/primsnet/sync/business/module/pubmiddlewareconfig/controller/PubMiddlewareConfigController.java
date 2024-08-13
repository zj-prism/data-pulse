package top.primsnet.sync.business.module.pubmiddlewareconfig.controller;

import top.primsnet.sync.business.module.pubmiddlewareconfig.service.PubMiddlewareConfigService;
import top.primsnet.sync.business.module.pubmiddlewareconfig.vo.PubMiddlewareConfigReqVO;
import top.primsnet.sync.business.module.pubmiddlewareconfig.vo.PubMiddlewareConfigResVO;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.result.Result;

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
 * @since 2024-08-02 09:34:40
 */

@Api(tags = "pubmiddlewareconfig")
@Controller
@Mapping("/pubmiddlewareconfig")
public class PubMiddlewareConfigController {


    @Inject
    private PubMiddlewareConfigService pubMiddlewareConfigService;

    @Mapping(value = "page",method = MethodType.GET)
    @ApiOperation("分页")
    public Result<PageResult<PubMiddlewareConfigResVO>> page(PubMiddlewareConfigReqVO reqVO){
        return Result.ok(pubMiddlewareConfigService.page(reqVO));
    }

    @Mapping(value = "list",method = MethodType.GET)
    @ApiOperation("列表")
    public Result<List<PubMiddlewareConfigResVO>> list(PubMiddlewareConfigReqVO reqVO){
        return Result.ok(pubMiddlewareConfigService.list(reqVO));
    }

    @Mapping(value = "detail",method = MethodType.GET)
    @ApiOperation("详情")
    public Result<PubMiddlewareConfigResVO> detail(Integer id){
        return Result.ok(pubMiddlewareConfigService.detail(id));
    }

    @Mapping(value = "add",method = MethodType.POST)
    @ApiOperation("新增")
    public Result<String> add(PubMiddlewareConfigReqVO reqVO){
        pubMiddlewareConfigService.add(reqVO);
        return Result.ok();
    }
    @Mapping(value = "edit",method = MethodType.POST)
    @ApiOperation("编辑")
    public Result<String> edit(PubMiddlewareConfigReqVO reqVO){
        pubMiddlewareConfigService.edit(reqVO);
        return Result.ok();
    }

    @Mapping(value = "delete",method = MethodType.GET)
    @ApiOperation("删除")
    public Result<String> delete(Integer id){
        pubMiddlewareConfigService.delete(id);
        return Result.ok();
    }
}
