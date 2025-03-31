package top.prism.sync.business.module.syncfieldsconfig.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Component;
import org.noear.solon.data.annotation.Tran;
import top.prism.sync.business.module.syncfieldsconfig.convert.SyncFieldsConfigConvert;
import top.prism.sync.business.module.syncfieldsconfig.entity.SyncFieldsConfig;
import top.prism.sync.business.module.syncfieldsconfig.mapper.SyncFieldsConfigMapper;
import top.prism.sync.business.module.syncfieldsconfig.service.SyncFieldsConfigService;
import top.prism.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigReqVO;
import top.prism.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigResVO;
import top.prism.sync.common.mybatis.base.BaseServiceImpl;
import top.prism.sync.common.mybatis.base.PageResult;
import top.prism.sync.common.mybatis.page.PageProcess;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:41:40
 */
@Component
public class SyncFieldsConfigServiceImpl extends BaseServiceImpl<SyncFieldsConfigMapper, SyncFieldsConfig> implements SyncFieldsConfigService {
    @Override
    @ApiOperation("分页")
    public PageResult<SyncFieldsConfigResVO> page(SyncFieldsConfigReqVO reqVO) {
       return PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
    }

    @Override
    @ApiOperation("列表")
    public List<SyncFieldsConfigResVO> list(SyncFieldsConfigReqVO reqVO) {
       return SyncFieldsConfigConvert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
    }

     @Override
     @ApiOperation("详情")
     public SyncFieldsConfigResVO detail(Integer id) {
        return SyncFieldsConfigConvert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(SyncFieldsConfigReqVO reqVO) {
        SyncFieldsConfig entity = SyncFieldsConfigConvert.INSTANCE.convert(reqVO);
        save(entity);
     }

    /**
     * @param reqVO
     */
    @Override
    public void addAll(List<SyncFieldsConfigReqVO> reqVO) {
        List<SyncFieldsConfig> syncFieldsConfigs = SyncFieldsConfigConvert.INSTANCE.convertAll(reqVO);
        saveBatch(syncFieldsConfigs);
    }

     @Override
     @ApiOperation("编辑")
     public void edit(SyncFieldsConfigReqVO reqVO) {
        SyncFieldsConfig entity = SyncFieldsConfigConvert.INSTANCE.convert(reqVO);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }

    /**
     * 字段绑定
     * @param tableBindId 表绑定关系 ID
     * @param fieldBindList 字段对应关系
     */
    @Tran
    @Override
    public void fieldBind(Integer tableBindId, ArrayList<SyncFieldsConfig> fieldBindList) {
        List<SyncFieldsConfig> list = this.lambdaQuery().eq(SyncFieldsConfig::getBaseId, tableBindId).list();
        if (ObjUtil.isNotEmpty(list)){
            this.removeBatchByIds(list.stream().map(SyncFieldsConfig::getId).toList());
        }
        this.saveBatch(fieldBindList);
    }

    private QueryWrapper<SyncFieldsConfig> getQueryWrapper(SyncFieldsConfigReqVO reqVO) {
        QueryWrapper<SyncFieldsConfig> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){

        }
        return queryWrapper;
    }
}

