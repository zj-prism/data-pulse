package top.primsnet.sync.business.module.sysuser.convert;

import top.primsnet.sync.business.module.sysuser.entity.SysUser;
import top.primsnet.sync.business.module.sysuser.vo.SysUserReqVO;
import top.primsnet.sync.business.module.sysuser.vo.SysUserResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* Author joshua
* @since 2024-11-01 17:56:23
*/
@Mapper
public interface SysUserConvert{

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUser convert(SysUserReqVO reqVO);
    SysUserResVO convert(SysUser reqVO);
    List<SysUserResVO> convert(List<SysUser> reqVO);
}



