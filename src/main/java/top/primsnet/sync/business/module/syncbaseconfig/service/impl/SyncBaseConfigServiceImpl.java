package top.primsnet.sync.business.module.syncbaseconfig.service.impl;

import top.primsnet.sync.business.module.syncbaseconfig.entity.SyncBaseConfig;
import top.primsnet.sync.business.module.syncbaseconfig.service.SyncBaseConfigService;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigResVO;
import top.primsnet.sync.business.module.syncbaseconfig.convert.SyncBaseConfigConvert;
import top.primsnet.sync.business.module.syncbaseconfig.mapper.SyncBaseConfigMapper;
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
 * Author joshua
 * @since 2024-11-01 17:40:38
 */
@Component
public class SyncBaseConfigServiceImpl extends BaseServiceImpl<SyncBaseConfigMapper, SyncBaseConfig> implements SyncBaseConfigService {
    @Override
    @ApiOperation("分页")
    public PageResult<SyncBaseConfigResVO> page(SyncBaseConfigReqVO reqVO) {
       return PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
    }

    @Override
    @ApiOperation("列表")
    public List<SyncBaseConfigResVO> list(SyncBaseConfigReqVO reqVO) {
       return SyncBaseConfigConvert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
    }

     @Override
     @ApiOperation("详情")
     public SyncBaseConfigResVO detail(Integer id) {
        return SyncBaseConfigConvert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(SyncBaseConfigReqVO reqVO) {
        SyncBaseConfig entity = SyncBaseConfigConvert.INSTANCE.convert(reqVO);
        save(entity);
     }

     @Override
     @ApiOperation("编辑")
     public void edit(SyncBaseConfigReqVO reqVO) {
        SyncBaseConfig entity = SyncBaseConfigConvert.INSTANCE.convert(reqVO);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }


     private QueryWrapper<SyncBaseConfig> getQueryWrapper(SyncBaseConfigReqVO reqVO) {
        QueryWrapper<SyncBaseConfig> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){

        }
        return queryWrapper;
    }
}

