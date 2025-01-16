package top.prism.sync.business.module.sysuser.service.impl;

import top.prism.sync.business.module.sysuser.entity.SysUser;
import top.prism.sync.business.module.sysuser.service.SysUserService;
import top.prism.sync.business.module.sysuser.vo.SysUserReqVO;
import top.prism.sync.business.module.sysuser.vo.SysUserResVO;
import top.prism.sync.business.module.sysuser.convert.SysUserConvert;
import top.prism.sync.business.module.sysuser.mapper.SysUserMapper;
import cn.hutool.core.util.ObjUtil;
import top.prism.sync.common.mybatis.base.BaseServiceImpl;
import top.prism.sync.common.mybatis.base.PageResult;
import top.prism.sync.common.mybatis.page.PageProcess;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.noear.solon.annotation.Component;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * Author joshua
 * @since 2024-11-01 17:56:23
 */
@Component
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Override
    @ApiOperation("分页")
    public PageResult<SysUserResVO> page(SysUserReqVO reqVO) {
       return PageProcess.pageResult(reqVO, () -> list(getQueryWrapper(reqVO)));
    }

    @Override
    @ApiOperation("列表")
    public List<SysUserResVO> list(SysUserReqVO reqVO) {
       return SysUserConvert.INSTANCE.convert(list(getQueryWrapper(reqVO)));
    }

     @Override
     @ApiOperation("详情")
     public SysUserResVO detail(Integer id) {
        return SysUserConvert.INSTANCE.convert(getById(id));
     }


     @Override
     @ApiOperation("新增")
     public void add(SysUserReqVO reqVO) {
        SysUser entity = SysUserConvert.INSTANCE.convert(reqVO);
        save(entity);
     }

     @Override
     @ApiOperation("编辑")
     public void edit(SysUserReqVO reqVO) {
        SysUser entity = SysUserConvert.INSTANCE.convert(reqVO);
        updateById(entity);
     }

     @Override
     @ApiOperation("删除")
     public void delete(Integer id) {
       removeById(id);
     }


     private QueryWrapper<SysUser> getQueryWrapper(SysUserReqVO reqVO) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (ObjUtil.isNotEmpty(reqVO)){

        }
        return queryWrapper;
    }
}

