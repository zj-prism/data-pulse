package top.primsnet.sync.business.fdtaskbaseconfig.service.impl;

import top.primsnet.sync.business.fdtaskbaseconfig.entity.FdTaskBaseConfig;
import top.primsnet.sync.business.fdtaskbaseconfig.service.FdTaskBaseConfigService;
import top.primsnet.sync.business.fdtaskbaseconfig.vo.FdTaskBaseConfigReqVO;
import top.primsnet.sync.business.fdtaskbaseconfig.vo.FdTaskBaseConfigResVO;
import top.primsnet.sync.business.fdtaskbaseconfig.convert.FdTaskBaseConfigConvert;
import top.primsnet.sync.business.fdtaskbaseconfig.mapper.FdTaskBaseConfigMapper;
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
 * @since 2024-07-18
 */
@Component
public class FdTaskBaseConfigServiceImpl extends BaseServiceImpl<FdTaskBaseConfigMapper, FdTaskBaseConfig> implements FdTaskBaseConfigService {
    @Override
    @ApiOperation("分页")
    public PageResult<FdTaskBaseConfigResVO> page(FdTaskBaseConfigReqVO reqVO) {
       return PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
    }

    @Override
    @ApiOperation("列表")
    public List<FdTaskBaseConfigResVO> list(FdTaskBaseConfigReqVO reqVO) {
       return FdTaskBaseConfigConvert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
    }

     @Override
     @ApiOperation("详情")
     public FdTaskBaseConfigResVO detail(Integer id) {
        return FdTaskBaseConfigConvert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(FdTaskBaseConfigReqVO reqVO) {
        FdTaskBaseConfig entity = FdTaskBaseConfigConvert.INSTANCE.convert(reqVO);
        save(entity);
     }

     @Override
     @ApiOperation("编辑")
     public void edit(FdTaskBaseConfigReqVO reqVO) {
        FdTaskBaseConfig entity = FdTaskBaseConfigConvert.INSTANCE.convert(reqVO);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }


     private QueryWrapper<FdTaskBaseConfig> getQueryWrapper(FdTaskBaseConfigReqVO reqVO) {
        QueryWrapper<FdTaskBaseConfig> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){

        }
        return queryWrapper;
    }
}

