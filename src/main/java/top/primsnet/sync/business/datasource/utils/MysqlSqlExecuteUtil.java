package top.primsnet.sync.business.datasource.utils;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.handler.EntityListHandler;
import cn.hutool.db.sql.SqlExecutor;
import top.primsnet.sync.common.exception.ServiceException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Author:  joshua
 * Description: TODO
 * DateTime: 2024/11/6 11:07
 **/
public class MysqlSqlExecuteUtil {


    /**
     * 执行mysql sql语句
     * @param dataSource 数据源
     * @param sqlStr sql语句
     * @return 数据集合
     */
    public static List<Entity> exec(DataSource dataSource,String sqlStr){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            return SqlExecutor.query(connection, sqlStr, new EntityListHandler());
        } catch (SQLException e) {
            throw new ServiceException("Mysql sql执行器执行sql失败:%s".formatted(ExceptionUtil.stacktraceToString(e)));
        }finally {
            DbUtil.close(connection);
        }
    }
}
