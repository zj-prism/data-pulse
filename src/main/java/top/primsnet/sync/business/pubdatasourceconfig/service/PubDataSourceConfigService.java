package top.primsnet.sync.business.pubdatasourceconfig.service;

import top.primsnet.sync.business.pubdatasourceconfig.entity.PubDataSourceConfig;
import top.primsnet.sync.business.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.primsnet.sync.business.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import java.util.List;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.mybatis.base.BaseService;
/**
 * <p>
 * 服务类
 * </p>
 *
 * @author joshua
 * @since 2024-07-23 22:20:29
 */
public interface PubDataSourceConfigService extends BaseService<PubDataSourceConfig> {
    PageResult<PubDataSourceConfigResVO> page(PubDataSourceConfigReqVO reqVO);
    List<PubDataSourceConfigResVO> list(PubDataSourceConfigReqVO reqVO);
    PubDataSourceConfigResVO detail(Integer id);
    void add(PubDataSourceConfigReqVO reqVO);
    void edit(PubDataSourceConfigReqVO reqVO);
    void delete(Integer id);
}
