package top.primsnet.sync.config.redis;

import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.cache.redisson.RedissonCacheService;
import org.noear.solon.cache.redisson.RedissonClientOriginalSupplier;
import org.noear.solon.data.cache.CacheService;

@Configuration
public class RedisConfig {
    @Bean(name = "cache1", typed = true) //typed 表示可类型注入 //即默认
    public CacheService cache1(@Inject("${redis.cache1}") RedissonCacheService cache){
        return cache;
    }

}