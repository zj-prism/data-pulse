package top.primsnet.sync.business.module.syncfieldsconfig.service;

import top.primsnet.sync.business.module.syncfieldsconfig.entity.SyncFieldsConfig;
import top.primsnet.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigReqVO;
import top.primsnet.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigResVO;
import top.primsnet.sync.common.mybatis.base.BaseService;
import top.primsnet.sync.common.mybatis.base.PageResult;

import java.util.List;
/**
 * <p>
 * 服务类
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:41:40
 */
public interface SyncFieldsConfigService extends BaseService<SyncFieldsConfig> {
    PageResult<SyncFieldsConfigResVO> page(SyncFieldsConfigReqVO reqVO);
    List<SyncFieldsConfigResVO> list(SyncFieldsConfigReqVO reqVO);
    SyncFieldsConfigResVO detail(Integer id);
    void add(SyncFieldsConfigReqVO reqVO);
    void addAll(List<SyncFieldsConfigReqVO> reqVO);
    void edit(SyncFieldsConfigReqVO reqVO);
    void delete(Integer id);
}
