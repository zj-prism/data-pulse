package top.primsnet.sync.common.mybatis.page;

import cn.hutool.core.util.ObjUtil;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import top.primsnet.sync.common.mybatis.base.BaseQuery;
import top.primsnet.sync.common.mybatis.base.PageResult;

/**
 * 封装分页
 */
public class PageProcess {

    /**
     * 返回pageHelper的page
     * @param baseQuery 请求参数
     * @param select 执行查询list的方法
     * @return page
     * @param <T> 实体类型
     */
    public static <T> Page<T> basePage(BaseQuery baseQuery, ISelect select) {
        Integer page = baseQuery.getPage();
        Integer limit = baseQuery.getLimit();
        if (ObjUtil.isEmpty(page)){
            page = 1;
        }
        if (ObjUtil.isEmpty(limit)){
            limit = 10;
        }
        return PageHelper.startPage(page, limit).doSelectPage(select);
    }

    /**
     * 返回分页结果包装类
     * @param baseQuery 请求参数
     * @param select 执行查询list的方法
     * @return 分页结果包装类
     * @param <T> 实体类型
     */
    public static <T> PageResult<T> pageResult(BaseQuery baseQuery, ISelect select) {
        Integer page = baseQuery.getPage();
        Integer limit = baseQuery.getLimit();
        if (ObjUtil.isEmpty(page)){
            page = 1;
        }
        if (ObjUtil.isEmpty(limit)){
            limit = 10;
        }
        Page<T> dataPage = PageHelper.startPage(page, limit).doSelectPage(select);
        return new PageResult<>(dataPage);
    }
}
