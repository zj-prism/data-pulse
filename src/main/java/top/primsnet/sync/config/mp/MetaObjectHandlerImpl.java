package top.primsnet.sync.config.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.noear.solon.annotation.Component;

import java.util.Date;

/**
 * @author noear 2022/4/17 created
 */
@Component
public class MetaObjectHandlerImpl implements MetaObjectHandler {
    public MetaObjectHandlerImpl(){
        System.out.println("....MetaObjectHandlerImpl");
    }
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("create_time",new Date());
        System.out.println("insertFill  insertFill  insertFill");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("updateFill updateFill updateFill");
    }
}
