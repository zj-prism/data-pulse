package top.primsnet.sync.business.module.syncbaseconfig.service.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import top.primsnet.sync.business.module.pubdatasourceconfig.service.PubDataSourceConfigService;
import top.primsnet.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.primsnet.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import top.primsnet.sync.business.module.syncbaseconfig.convert.SyncBaseConfigConvert;
import top.primsnet.sync.business.module.syncbaseconfig.entity.SyncBaseConfig;
import top.primsnet.sync.business.module.syncbaseconfig.mapper.SyncBaseConfigMapper;
import top.primsnet.sync.business.module.syncbaseconfig.service.SyncBaseConfigService;
import top.primsnet.sync.business.module.syncbaseconfig.vo.DataSourcesListResVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.FieldBindReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigResVO;
import top.primsnet.sync.business.module.syncfieldsconfig.service.SyncFieldsConfigService;
import top.primsnet.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigReqVO;
import top.primsnet.sync.common.enums.DataSourceLoadStatusTypeEnum;
import top.primsnet.sync.common.enums.PublicStatusTypeEnum;
import top.primsnet.sync.common.exception.ServiceException;
import top.primsnet.sync.common.mybatis.base.BaseServiceImpl;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.mybatis.page.PageProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Inject
    SyncFieldsConfigService fieldsConfigService;

    @Inject
    PubDataSourceConfigService dataSourceConfigService;

    @Override
    @ApiOperation("分页")
    public PageResult<SyncBaseConfigResVO> page(SyncBaseConfigReqVO reqVO) {
        PageResult<SyncBaseConfigResVO> objectPageResult = PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
        List<Integer> fromIds = new ArrayList<>(objectPageResult.getList().stream().map(SyncBaseConfigResVO::getFromId).toList());
        List<Integer> toIds = objectPageResult.getList().stream().map(SyncBaseConfigResVO::getToId).toList();
        fromIds.addAll(toIds);
        var dsParam= new PubDataSourceConfigReqVO();
        dsParam.setIds(fromIds);
        List<PubDataSourceConfigResVO> dsDatalist = dataSourceConfigService.list(dsParam);
        Map<Integer, String> dsDataMap = dsDatalist.stream().collect(Collectors.toMap(PubDataSourceConfigResVO::getId, PubDataSourceConfigResVO::getName));
        objectPageResult.getList().forEach(e->{
            e.setFromIdStr(dsDataMap.get(e.getFromId()));
            e.setToIdStr(dsDataMap.get(e.getToId()));
        });
        return objectPageResult;
    }

    @Override
    @ApiOperation("列表")
    public List<SyncBaseConfigResVO> list(SyncBaseConfigReqVO reqVO) {
        List<SyncBaseConfigResVO> list = SyncBaseConfigConvert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
        List<Integer> fromIds = new ArrayList<>(list.stream().map(SyncBaseConfigResVO::getFromId).toList());
        List<Integer> toIds = list.stream().map(SyncBaseConfigResVO::getToId).toList();
        fromIds.addAll(toIds);
        var dsParam= new PubDataSourceConfigReqVO();
        dsParam.setIds(fromIds);
        List<PubDataSourceConfigResVO> dsDatalist = dataSourceConfigService.list(dsParam);
        Map<Integer, String> dsDataMap = dsDatalist.stream().collect(Collectors.toMap(PubDataSourceConfigResVO::getId, PubDataSourceConfigResVO::getName));
        list.forEach(e->{
            e.setFromIdStr(dsDataMap.get(e.getFromId()));
            e.setToIdStr(dsDataMap.get(e.getToId()));
        });
        return list;
    }

     @Override
     @ApiOperation("详情")
     public SyncBaseConfigResVO detail(Integer id) {
        return SyncBaseConfigConvert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(SyncBaseConfigReqVO reqVO) {
        reqVO.setStatus(PublicStatusTypeEnum.CLOSE.getValue());
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

    /**
     * @param id 基础配置ID
     * @param reqVOs 绑定关系
     */
    @Override
    public void fieldBind(Integer id, List<FieldBindReqVO> reqVOs) {
        if (ObjUtil.hasEmpty(id,reqVOs)){
            throw new ServiceException("绑定失败,参数校验异常,ID不存在");
        }
        //校验
        SyncBaseConfig baseConfig = getById(id);
        if (ObjUtil.isEmpty(baseConfig)){
            throw new ServiceException("绑定失败,校验异常,当前配置不存在");
        }
        //保存关联关系
        List<SyncFieldsConfigReqVO> list = new ArrayList<>();
        for (FieldBindReqVO bindReqVO : reqVOs) {
            SyncFieldsConfigReqVO fieldsConfigReqVO = new SyncFieldsConfigReqVO();
            fieldsConfigReqVO.setBaseId(id);
            fieldsConfigReqVO.setFromField(bindReqVO.getFromFieldName());
            fieldsConfigReqVO.setToField(bindReqVO.getToFieldName());
            fieldsConfigReqVO.setTransType(bindReqVO.getTransType());
            fieldsConfigReqVO.setFromFieldType(bindReqVO.getFromFieldType());
            fieldsConfigReqVO.setToFieldType(bindReqVO.getToFieldType());
            list.add(fieldsConfigReqVO);
        }
        fieldsConfigService.addAll(list);
    }

    private QueryWrapper<SyncBaseConfig> getQueryWrapper(SyncBaseConfigReqVO reqVO) {
        QueryWrapper<SyncBaseConfig> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){
            if (StrUtil.isNotEmpty(reqVO.getName())){
                queryWrapper.lambda().like(SyncBaseConfig::getName,reqVO.getName());
            }
            if (StrUtil.isNotEmpty(reqVO.getType())){
                queryWrapper.lambda().eq(SyncBaseConfig::getType,reqVO.getType());
            }
            if (ObjUtil.isNotEmpty(reqVO.getStatus())){
                queryWrapper.lambda().eq(SyncBaseConfig::getStatus,reqVO.getStatus());
            }
        }
        return queryWrapper;
    }

    @Override
    public List<DataSourcesListResVO> getDataSourcesList() {
        var dataSourceConfigReqVO = new PubDataSourceConfigReqVO();
        dataSourceConfigReqVO.setLoadStatus(DataSourceLoadStatusTypeEnum.LOADING.getValue());
        List<PubDataSourceConfigResVO> list = dataSourceConfigService.list(dataSourceConfigReqVO);
        return list.stream().map(ds -> {
            var sourcesListResVO = new DataSourcesListResVO();
            sourcesListResVO.setId(ds.getId());
            sourcesListResVO.setName(ds.getName());
            return sourcesListResVO;
        }).toList();
    }

    @Override
    public void loadStatus(Integer id) {
        SyncBaseConfig entity = getById(id);
        if (ObjUtil.isEmpty(entity)){
            throw new ServiceException("开启同步配置失败,该配置不存在");
        }

        //TODO 后续需要增加打开后开启实时同步工作    ---- 不同类型有不同的开启操作
        entity.setStatus(PublicStatusTypeEnum.OPEN.getValue());
        updateById(entity);
    }

    @Override
    public void unloadStatus(Integer id) {
        SyncBaseConfig entity = getById(id);
        if (ObjUtil.isEmpty(entity)){
            throw new ServiceException("开启同步配置失败,该配置不存在");
        }

        //TODO 后续需要增加打开后关闭实时同步工作    ---- 不同类型有不同的关闭操作
        entity.setStatus(PublicStatusTypeEnum.CLOSE.getValue());
        updateById(entity);
    }
}

