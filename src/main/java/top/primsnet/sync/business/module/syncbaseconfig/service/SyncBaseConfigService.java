package top.primsnet.sync.business.module.syncbaseconfig.service;

import top.primsnet.sync.business.module.syncbaseconfig.entity.SyncBaseConfig;
import top.primsnet.sync.business.module.syncbaseconfig.vo.DataSourcesListResVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.FieldBindReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigResVO;
import top.primsnet.sync.common.mybatis.base.BaseService;
import top.primsnet.sync.common.mybatis.base.PageResult;

import java.util.List;
/**
 * <p>
 * 服务类
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:40:38
 */
public interface SyncBaseConfigService extends BaseService<SyncBaseConfig> {
    PageResult<SyncBaseConfigResVO> page(SyncBaseConfigReqVO reqVO);
    List<SyncBaseConfigResVO> list(SyncBaseConfigReqVO reqVO);
    SyncBaseConfigResVO detail(Integer id);
    void add(SyncBaseConfigReqVO reqVO);
    void edit(SyncBaseConfigReqVO reqVO);
    void delete(Integer id);
    void fieldBind(Integer id, List<FieldBindReqVO> reqVOs);

    List<DataSourcesListResVO> getDataSourcesList();

    void loadStatus(Integer id);

    void unloadStatus(Integer id);
}
