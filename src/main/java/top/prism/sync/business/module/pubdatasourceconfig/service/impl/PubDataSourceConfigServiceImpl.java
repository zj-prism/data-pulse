package top.prism.sync.business.module.pubdatasourceconfig.service.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.annotation.Tran;
import top.prism.sync.business.datasource.service.DataSourceServiceContext;
import top.prism.sync.business.datasource.to.CreateDataSourceStrTO;
import top.prism.sync.business.datasource.to.GetDataSourceFieldsTO;
import top.prism.sync.business.module.pubdatasourceconfig.convert.PubDataSourceConfigConvert;
import top.prism.sync.business.module.pubdatasourceconfig.entity.PubDataSourceConfig;
import top.prism.sync.business.module.pubdatasourceconfig.mapper.PubDataSourceConfigMapper;
import top.prism.sync.business.module.pubdatasourceconfig.service.PubDataSourceConfigService;
import top.prism.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.prism.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import top.prism.sync.common.enums.DataSourceLoadStatusTypeEnum;
import top.prism.sync.common.enums.DataSourceTypeEnum;
import top.prism.sync.common.enums.SysCommonEnum;
import top.prism.sync.common.exception.ServiceException;
import top.prism.sync.common.mybatis.base.BaseServiceImpl;
import top.prism.sync.common.mybatis.base.PageResult;
import top.prism.sync.common.mybatis.page.PageProcess;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * Author joshua
 * @since 2024-07-30 14:30:12
 */
@Component
public class PubDataSourceConfigServiceImpl extends BaseServiceImpl<PubDataSourceConfigMapper, PubDataSourceConfig> implements PubDataSourceConfigService {

    @Inject
    DataSourceServiceContext dataSourceServiceContext;

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
     @Tran
     public void add(PubDataSourceConfigReqVO reqVO) {
        //默认未装载
        reqVO.setLoadStatus(DataSourceLoadStatusTypeEnum.NOLOADING.getValue());
        PubDataSourceConfig entity = PubDataSourceConfigConvert.INSTANCE.convert(reqVO);
        //封装数据源加载json
         CreateDataSourceStrTO dataSourceStrTO = new CreateDataSourceStrTO();
         dataSourceStrTO.setType(DataSourceTypeEnum.MYSQL.getValue());
         dataSourceStrTO.setBeanName(reqVO.getName());
         dataSourceStrTO.setUrl(reqVO.getUrl());
         dataSourceStrTO.setUserName(reqVO.getUserName());
         dataSourceStrTO.setPassword(reqVO.getPassword());
         String dataSourceStr = dataSourceServiceContext.getService(DataSourceTypeEnum.getByValue(reqVO.getType()).getRemark()).createDataSourceStr(dataSourceStrTO);
         entity.setConfigJsonStr(dataSourceStr);
         save(entity);
     }

     @Override
     @ApiOperation("编辑")
     public void edit(PubDataSourceConfigReqVO reqVO) {
         PubDataSourceConfig entity = PubDataSourceConfigConvert.INSTANCE.convert(reqVO);
         //封装数据源加载json
         CreateDataSourceStrTO dataSourceStrTO = new CreateDataSourceStrTO();
         dataSourceStrTO.setType(DataSourceTypeEnum.MYSQL.getValue());
         dataSourceStrTO.setBeanName(reqVO.getName());
         dataSourceStrTO.setUrl(reqVO.getUrl());
         dataSourceStrTO.setUserName(reqVO.getUserName());
         dataSourceStrTO.setPassword(reqVO.getPassword());
         String dataSourceStr = dataSourceServiceContext.getService(DataSourceTypeEnum.MYSQL.getRemark()).createDataSourceStr(dataSourceStrTO);
         entity.setConfigJsonStr(dataSourceStr);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }

    /**
     * 加载数据源
     * @param id 数据源ID
     */
    @Override
    public void loadDataSource(Integer id) {
        PubDataSourceConfig entity = getById(id);
        if (ObjUtil.isEmpty(entity) || StrUtil.isEmpty(entity.getConfigJsonStr())){
            throw new ServiceException("加载数据源失败,数据源配置不存在,请重新配置数据源");
        }
        Integer type = entity.getType();
        DataSourceTypeEnum dataSourceTypeEnum = DataSourceTypeEnum.getByValue(type);
        if (ObjUtil.isEmpty(dataSourceTypeEnum)){
            throw new ServiceException("当前数据源未兼容");
        }
        //加载数据源
        dataSourceServiceContext.getService(dataSourceTypeEnum.getRemark()).initDataSource(entity.getName(),entity.getConfigJsonStr());
        //更改数据源加载状态
        entity.setLoadStatus((Integer) SysCommonEnum.DATA_SOURCE_LOAD_OPEN_TYPE.getValue());
        updateById(entity);
    }

    /**
     * @param id
     */
    @Override
    public void unloadDataSource(Integer id) {
        PubDataSourceConfig entity = getById(id);
        if (ObjUtil.isEmpty(entity) || StrUtil.isEmpty(entity.getConfigJsonStr())){
            throw new ServiceException("加载数据源失败,数据源配置不存在,请重新配置数据源");
        }
        Integer type = entity.getType();
        DataSourceTypeEnum dataSourceTypeEnum = DataSourceTypeEnum.getByValue(type);
        if (ObjUtil.isEmpty(dataSourceTypeEnum)){
            throw new ServiceException("当前数据源未兼容");
        }
        dataSourceServiceContext.getService(dataSourceTypeEnum.getRemark()).logoutDataSource(entity.getName());
        entity.setLoadStatus((Integer) SysCommonEnum.DATA_SOURCE_LOAD_CLOSE_TYPE.getValue());
        updateById(entity);
    }

    /**
     * 获取数据源表字段
     * @param tableName 表名称
     * @return 字段集合
     */
    @Override
    public List<GetDataSourceFieldsTO> getFields(Integer id,String tableName) {
        PubDataSourceConfig entity = getById(id);
        if (ObjUtil.isEmpty(entity) || StrUtil.isEmpty(entity.getConfigJsonStr())){
            throw new ServiceException("加载数据源失败,数据源配置不存在,请重新配置数据源");
        }
        Integer type = entity.getType();
        DataSourceTypeEnum dataSourceTypeEnum = DataSourceTypeEnum.getByValue(type);
        if (ObjUtil.isEmpty(dataSourceTypeEnum)){
            throw new ServiceException("当前数据源未兼容");
        }
        return dataSourceServiceContext.getService(dataSourceTypeEnum.getRemark()).getFields(entity.getName(),tableName);
    }

    private QueryWrapper<PubDataSourceConfig> getQueryWrapper(PubDataSourceConfigReqVO reqVO) {
        QueryWrapper<PubDataSourceConfig> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){
            if (StrUtil.isNotBlank(reqVO.getName())){
                queryWrapper.lambda().like(PubDataSourceConfig::getName,reqVO.getName());
            }
            if (ObjUtil.isNotEmpty(reqVO.getLoadStatus())){
                queryWrapper.lambda().eq(PubDataSourceConfig::getLoadStatus,reqVO.getLoadStatus());
            }
        }
        return queryWrapper;
    }
}

