package top.prism.sync.business.module.sysuser.service;

import top.prism.sync.business.module.sysuser.entity.SysUser;
import top.prism.sync.business.module.sysuser.vo.SysUserReqVO;
import top.prism.sync.business.module.sysuser.vo.SysUserResVO;
import java.util.List;
import top.prism.sync.common.mybatis.base.PageResult;
import top.prism.sync.common.mybatis.base.BaseService;
/**
 * <p>
 * 服务类
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:56:23
 */
public interface SysUserService extends BaseService<SysUser> {
    PageResult<SysUserResVO> page(SysUserReqVO reqVO);
    List<SysUserResVO> list(SysUserReqVO reqVO);
    SysUserResVO detail(Integer id);
    void add(SysUserReqVO reqVO);
    void edit(SysUserReqVO reqVO);
    void delete(Integer id);
}
