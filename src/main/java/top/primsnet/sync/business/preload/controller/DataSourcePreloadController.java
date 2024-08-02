package top.primsnet.sync.business.preload.controller;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.Utils;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import org.noear.solon.core.Props;
import org.noear.solon.core.handle.MethodType;
import org.noear.solon.data.dynamicds.DynamicDataSource;
import org.noear.solon.data.dynamicds.DynamicDs;
import org.noear.solon.data.dynamicds.DynamicDsKey;
import top.primsnet.sync.business.preload.vo.DataSourcePreloadReqVO;
import top.primsnet.sync.business.pubdatasourceconfig.service.PubDataSourceConfigService;

import javax.sql.DataSource;


/**
 * @Author: joshua
 * @Description: TODO
 * @DateTime: 2024/8/2 下午4:30
 **/
@Controller
public class DataSourcePreloadController {

    @Inject
    DynamicDataSource dds;

    @Inject
    PubDataSourceConfigService dataSourceConfigService;

    @Mapping(value = "ds/add",method = MethodType.POST)
    public void dsAdd(DataSourcePreloadReqVO reqVO){
        System.out.println("ds===" + DynamicDsKey.getCurrent());
        Props props = new Props();
        props.loadAdd(Utils.buildProperties(reqVO.getConfigJsonStr()));
        DataSource ds = props.getBean(HikariDataSource.class);
        dds.addTargetDataSource(reqVO.getName(), ds);
        System.out.println("dsAdd");
    }

    //注解设置二级源
    @Mapping("ds/use")
    public void dsUse(String dsName){
        DynamicDsKey.setCurrent(dsName);
    }
}
