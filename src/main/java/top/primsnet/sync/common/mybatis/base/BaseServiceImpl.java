package top.primsnet.sync.common.mybatis.base;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.solon.plugins.pagination.Page;
import com.baomidou.mybatisplus.solon.service.impl.ServiceImpl;
import top.primsnet.sync.common.mybatis.MyBaseMapper;

public class BaseServiceImpl<M extends MyBaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    /**
     * 获取分页对象
     *
     * @param baseQuery 分页参数
     */
    protected IPage<T> getPage(BaseQuery baseQuery) {
        Page<T> page = new Page<>(baseQuery.getPage(), baseQuery.getLimit());

        // 排序
        if (StrUtil.isNotBlank(baseQuery.getOrder())) {
            if (baseQuery.isAsc()) {
                return page.addOrder(OrderItem.asc(baseQuery.getOrder()));
            } else {
                return page.addOrder(OrderItem.desc(baseQuery.getOrder()));
            }
        }

        return page;
    }

    protected Page<T> getPageSql(BaseQuery baseQuery) {
        Page<T> page = new Page<>(baseQuery.getPage(), baseQuery.getLimit());

        // 排序
        if (StrUtil.isNotBlank(baseQuery.getOrder())) {
            if (baseQuery.isAsc()) {
                return page.addOrder(OrderItem.asc(baseQuery.getOrder()));
            } else {
                return page.addOrder(OrderItem.desc(baseQuery.getOrder()));
            }
        }

        return page;
    }



}