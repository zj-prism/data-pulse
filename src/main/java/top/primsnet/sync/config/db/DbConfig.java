package top.primsnet.sync.config.db;

import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.data.dynamicds.DynamicDataSource;


@Configuration
@Slf4j
public class DbConfig {
    @Bean(value = "db1", typed = true)
    public DynamicDataSource db1(@Inject("${db.db1}") DynamicDataSource ds) {
        return ds;
    }
}
