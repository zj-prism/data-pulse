package top.primsnet.sync.common.mybatis.base;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int total;

    private List<T> list;

    /**
     * 分页
     * @param list   列表数据
     * @param total  总记录数
     */
    public PageResult(List<T> list, long total) {
        this.list = list;
        this.total = (int)total;
    }

    public PageResult(Page<T> page){
        this.list = page.getResult();
        this.total = (int) page.getTotal();
    }
}