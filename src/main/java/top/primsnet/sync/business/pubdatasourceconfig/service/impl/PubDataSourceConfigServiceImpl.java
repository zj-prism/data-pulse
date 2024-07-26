package top.primsnet.sync.business.pubdatasourceconfig.service.impl;

import top.primsnet.sync.business.pubdatasourceconfig.entity.PubDataSourceConfig;
import top.primsnet.sync.business.pubdatasourceconfig.service.PubDataSourceConfigService;
import top.primsnet.sync.business.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.primsnet.sync.business.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import top.primsnet.sync.business.pubdatasourceconfig.convert.PubDataSourceConfigConvert;
import top.primsnet.sync.business.pubdatasourceconfig.mapper.PubDataSourceConfigMapper;
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
 * @since 2024-07-23 22:20:29
 */
@Component
public class PubDataSourceConfigServiceImpl extends BaseServiceImpl<PubDataSourceConfigMapper, PubDataSourceConfig> implements PubDataSourceConfigService {
    @Override
    @ApiOperation("分页")
    public PageResult<PubDataSourceConfigResVO> page(PubDataSourceConfigReqVO reqVO) {
       return PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
    }

    @Override
    @ApiOperation("列表")
    public List<PubDataSourceConfigResVO> list(PubDataSourceConfigReqVO reqVO) {
       return PubDataSourceConfigConvert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
    }

     @Override
     @ApiOperation("详情")
     public PubDataSourceConfigResVO detail(Integer id) {
        return PubDataSourceConfigConvert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(PubDataSourceConfigReqVO reqVO) {
        PubDataSourceConfig entity = PubDataSourceConfigConvert.INSTANCE.convert(reqVO);
        save(entity);
     }

     @Override
     @ApiOperation("编辑")
     public void edit(PubDataSourceConfigReqVO reqVO) {
        PubDataSourceConfig entity = PubDataSourceConfigConvert.INSTANCE.convert(reqVO);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }


     private QueryWrapper<PubDataSourceConfig> getQueryWrapper(PubDataSourceConfigReqVO reqVO) {
        QueryWrapper<PubDataSourceConfig> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){

        }
        return queryWrapper;
    }
}

