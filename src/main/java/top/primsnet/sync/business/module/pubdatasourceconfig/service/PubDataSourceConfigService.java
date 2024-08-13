package top.primsnet.sync.business.module.pubdatasourceconfig.service;

import top.primsnet.sync.business.module.pubdatasourceconfig.entity.PubDataSourceConfig;
import top.primsnet.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.primsnet.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import java.util.List;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.mybatis.base.BaseService;
/**
 * <p>
 * 服务类
 * </p>
 *
 * Author joshua
 * @since 2024-07-30 14:30:12
 */
public interface PubDataSourceConfigService extends BaseService<PubDataSourceConfig> {
    PageResult<PubDataSourceConfigResVO> page(PubDataSourceConfigReqVO reqVO);
    List<PubDataSourceConfigResVO> list(PubDataSourceConfigReqVO reqVO);
    PubDataSourceConfigResVO detail(Integer id);
    void add(PubDataSourceConfigReqVO reqVO);
    void edit(PubDataSourceConfigReqVO reqVO);
    void delete(Integer id);
    void loadDataSource(Integer id);
    void unloadDataSource(Integer id);
}
