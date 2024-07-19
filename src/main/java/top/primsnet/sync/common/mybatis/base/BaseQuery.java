package top.primsnet.sync.common.mybatis.base;

import lombok.Data;
import org.noear.solon.validation.annotation.Min;
import org.noear.solon.validation.annotation.NotNull;
import org.noear.solon.validation.annotation.Range;

import java.io.Serializable;

@Data
public class BaseQuery implements Serializable {
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为 1")
    Integer page = 1;

    @NotNull(message = "每页条数不能为空")
    @Range(min = 1, max = 1000, message = "每页条数，取值范围 1-1000")
    Integer limit = 10;

    //排序
    String order;

    //是否升序
    boolean asc;
}
