package top.primsnet.sync.business.module.synctableconfig.service.impl;

import top.primsnet.sync.business.module.synctableconfig.entity.SyncTableConfig;
import top.primsnet.sync.business.module.synctableconfig.service.SyncTableConfigService;
import top.primsnet.sync.business.module.synctableconfig.vo.SyncTableConfigReqVO;
import top.primsnet.sync.business.module.synctableconfig.vo.SyncTableConfigResVO;
import top.primsnet.sync.business.module.synctableconfig.convert.SyncTableConfigConvert;
import top.primsnet.sync.business.module.synctableconfig.mapper.SyncTableConfigMapper;
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
 * @since 2024-12-27 14:02:16
 */
@Component
public class SyncTableConfigServiceImpl extends BaseServiceImpl<SyncTableConfigMapper, SyncTableConfig> implements SyncTableConfigService {
    @Override
    @ApiOperation("分页")
    public PageResult<SyncTableConfigResVO> page(SyncTableConfigReqVO reqVO) {
       return PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
    }

    @Override
    @ApiOperation("列表")
    public List<SyncTableConfigResVO> list(SyncTableConfigReqVO reqVO) {
       return SyncTableConfigConvert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
    }

     @Override
     @ApiOperation("详情")
     public SyncTableConfigResVO detail(Integer id) {
        return SyncTableConfigConvert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(SyncTableConfigReqVO reqVO) {
        SyncTableConfig entity = SyncTableConfigConvert.INSTANCE.convert(reqVO);
        save(entity);
     }

     @Override
     @ApiOperation("编辑")
     public void edit(SyncTableConfigReqVO reqVO) {
        SyncTableConfig entity = SyncTableConfigConvert.INSTANCE.convert(reqVO);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }


     private QueryWrapper<SyncTableConfig> getQueryWrapper(SyncTableConfigReqVO reqVO) {
        QueryWrapper<SyncTableConfig> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){

        }
        return queryWrapper;
    }
}

