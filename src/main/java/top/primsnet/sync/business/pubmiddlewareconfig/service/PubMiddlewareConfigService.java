package top.primsnet.sync.business.pubmiddlewareconfig.service;

import top.primsnet.sync.business.pubmiddlewareconfig.entity.PubMiddlewareConfig;
import top.primsnet.sync.business.pubmiddlewareconfig.vo.PubMiddlewareConfigReqVO;
import top.primsnet.sync.business.pubmiddlewareconfig.vo.PubMiddlewareConfigResVO;
import java.util.List;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.mybatis.base.BaseService;
/**
 * <p>
 * 服务类
 * </p>
 *
 * @author joshua
 * @since 2024-08-02 09:34:40
 */
public interface PubMiddlewareConfigService extends BaseService<PubMiddlewareConfig> {
    PageResult<PubMiddlewareConfigResVO> page(PubMiddlewareConfigReqVO reqVO);
    List<PubMiddlewareConfigResVO> list(PubMiddlewareConfigReqVO reqVO);
    PubMiddlewareConfigResVO detail(Integer id);
    void add(PubMiddlewareConfigReqVO reqVO);
    void edit(PubMiddlewareConfigReqVO reqVO);
    void delete(Integer id);
}
