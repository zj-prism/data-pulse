package top.primsnet.sync.config.mp;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Author noear 2021/10/20 created
 */
public class MybatisSqlSessionFactoryBuilderImpl extends MybatisSqlSessionFactoryBuilder {
    @Override
    public SqlSessionFactory build(Configuration configuration) {
        System.out.println(".进来了.");
        return super.build(configuration);
    }
}
