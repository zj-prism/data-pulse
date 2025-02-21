package top.prism.sync.common.mybatis.base;

import com.baomidou.mybatisplus.solon.service.impl.ServiceImpl;
import top.prism.sync.common.mybatis.MyBaseMapper;

public class BaseServiceImpl<M extends MyBaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    
}