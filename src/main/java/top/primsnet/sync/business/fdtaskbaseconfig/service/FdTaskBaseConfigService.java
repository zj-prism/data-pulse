package top.primsnet.sync.business.fdtaskbaseconfig.service;

import top.primsnet.sync.business.fdtaskbaseconfig.entity.FdTaskBaseConfig;
import top.primsnet.sync.business.fdtaskbaseconfig.vo.FdTaskBaseConfigReqVO;
import top.primsnet.sync.business.fdtaskbaseconfig.vo.FdTaskBaseConfigResVO;
import java.util.List;
import top.primsnet.sync.common.mybatis.base.PageResult;
import top.primsnet.sync.common.mybatis.base.BaseService;
/**
 * <p>
 * 服务类
 * </p>
 *
 * @author joshua
 * @since 2024-07-18
 */
public interface FdTaskBaseConfigService extends BaseService<FdTaskBaseConfig> {
    PageResult<FdTaskBaseConfigResVO> page(FdTaskBaseConfigReqVO reqVO);
    List<FdTaskBaseConfigResVO> list(FdTaskBaseConfigReqVO reqVO);
    FdTaskBaseConfigResVO detail(Integer id);
    void add(FdTaskBaseConfigReqVO reqVO);
    void edit(FdTaskBaseConfigReqVO reqVO);
    void delete(Integer id);
}
