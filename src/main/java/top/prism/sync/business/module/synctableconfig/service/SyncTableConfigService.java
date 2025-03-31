package top.prism.sync.business.module.synctableconfig.service;

import top.prism.sync.business.module.synctableconfig.entity.SyncTableConfig;
import top.prism.sync.business.module.synctableconfig.vo.SyncTableConfigReqVO;
import top.prism.sync.business.module.synctableconfig.vo.SyncTableConfigResVO;
import top.prism.sync.common.mybatis.base.BaseService;
import top.prism.sync.common.mybatis.base.PageResult;

import java.util.List;
/**
 * <p>
 * 服务类
 * </p>
 *
 * Author joshua
 * @since 2024-12-27 14:02:16
 */
public interface SyncTableConfigService extends BaseService<SyncTableConfig> {
    PageResult<SyncTableConfigResVO> page(SyncTableConfigReqVO reqVO);
    List<SyncTableConfigResVO> list(SyncTableConfigReqVO reqVO);
    SyncTableConfigResVO detail(Integer id);
    void add(SyncTableConfigReqVO reqVO);
    void edit(SyncTableConfigReqVO reqVO);
    void delete(Integer id);

    Integer tableBind(SyncTableConfig tableConfig);
}
