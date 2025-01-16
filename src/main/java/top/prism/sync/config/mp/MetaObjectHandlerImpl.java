package top.prism.sync.config.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.noear.solon.annotation.Component;

import java.util.Date;

/**
 * Author noear 2022/4/17 created
 */
@Component
@Slf4j
public class MetaObjectHandlerImpl implements MetaObjectHandler {
    public MetaObjectHandlerImpl(){
        log.info("进入了自动填充-MetaObjectHandlerImpl");
    }
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("create_time",new Date());
        log.info("进入了数据自动填充-insertFill");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("进入了数据自动填充-updateFill");
    }
}
