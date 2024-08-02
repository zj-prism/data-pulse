package top.primsnet.sync.business.pubmiddlewareconfig.service.impl;

import top.primsnet.sync.business.pubmiddlewareconfig.entity.PubMiddlewareConfig;
import top.primsnet.sync.business.pubmiddlewareconfig.service.PubMiddlewareConfigService;
import top.primsnet.sync.business.pubmiddlewareconfig.vo.PubMiddlewareConfigReqVO;
import top.primsnet.sync.business.pubmiddlewareconfig.vo.PubMiddlewareConfigResVO;
import top.primsnet.sync.business.pubmiddlewareconfig.convert.PubMiddlewareConfigConvert;
import top.primsnet.sync.business.pubmiddlewareconfig.mapper.PubMiddlewareConfigMapper;
import cn.hutool.core.util.ObjUtil;
import top.primsnet.sync.common.mybatis.base.BaseServiceImpl;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.mybatis.page.PageProcess;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Component;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author joshua
 * @since 2024-08-02 09:34:40
 */
@Component
public class PubMiddlewareConfigServiceImpl extends BaseServiceImpl<PubMiddlewareConfigMapper, PubMiddlewareConfig> implements PubMiddlewareConfigService {
    @Override
    @ApiOperation("分页")
    public PageResult<PubMiddlewareConfigResVO> page(PubMiddlewareConfigReqVO reqVO) {
       return PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
    }

    @Override
    @ApiOperation("列表")
    public List<PubMiddlewareConfigResVO> list(PubMiddlewareConfigReqVO reqVO) {
       return PubMiddlewareConfigConvert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
    }

     @Override
     @ApiOperation("详情")
     public PubMiddlewareConfigResVO detail(Integer id) {
        return PubMiddlewareConfigConvert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(PubMiddlewareConfigReqVO reqVO) {
        PubMiddlewareConfig entity = PubMiddlewareConfigConvert.INSTANCE.convert(reqVO);
        save(entity);
     }

     @Override
     @ApiOperation("编辑")
     public void edit(PubMiddlewareConfigReqVO reqVO) {
        PubMiddlewareConfig entity = PubMiddlewareConfigConvert.INSTANCE.convert(reqVO);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }


     private QueryWrapper<PubMiddlewareConfig> getQueryWrapper(PubMiddlewareConfigReqVO reqVO) {
        QueryWrapper<PubMiddlewareConfig> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){

        }
        return queryWrapper;
    }
}

