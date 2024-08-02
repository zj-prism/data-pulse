package top.primsnet.sync.config.db;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.datasource.DsUtils;
import org.noear.solon.data.dynamicds.DynamicDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DbConfig {
    @Bean(value = "db1", typed = true)
    public DynamicDataSource db1(@Inject("${db.db1}") DynamicDataSource ds) {
        return ds;
    }

//    @Bean("db_user")
    public DataSource dsUser2(@Inject("${db.db1}") Properties props) {
        //手动构建，可以不用配置：type, strict
        Map<String, DataSource> dsMap = DsUtils.buildDsMap(props, HikariDataSource.class);
        DataSource dsDef = dsMap.get("default");

        DynamicDataSource tmp = new DynamicDataSource();
        tmp.setStrict(true);
        tmp.setTargetDataSources(dsMap);
        tmp.setDefaultTargetDataSource(dsDef);

        return tmp;
    }


//    @Bean
//    public DynamicDataSource dsInit(){
//        return new DynamicDataSource();
//    }

//    @Bean
//    public void db1_cfg(@Db("db1") MybatisConfiguration cfg,
//                        @Db("db1") GlobalConfig globalConfig) {
//        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
//        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//
//        cfg.setCacheEnabled(false);
//        cfg.addInterceptor(plusInterceptor);
//
//        globalConfig.setSqlInjector(new MyLogicSqlInjector());
//    }

//    @Bean
//    public MybatisSqlSessionFactoryBuilder factoryBuilderNew(){
//        return new MybatisSqlSessionFactoryBuilderImpl();
//    }
}
