package top.primsnet.sync.config.db;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Bean(value = "db1", typed = true)
    public DataSource db1(@Inject("${db.db1}") HikariDataSource ds) {
        return ds;
    }

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
