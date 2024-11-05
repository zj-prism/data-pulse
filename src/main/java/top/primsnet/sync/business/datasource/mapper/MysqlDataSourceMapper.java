package top.primsnet.sync.business.datasource.mapper;

import org.apache.ibatis.annotations.Param;
import org.noear.wood.xml.Namespace;
import top.primsnet.sync.business.datasource.to.GetDataSourceFieldsTO;

import java.util.List;

/**
 * Author:  joshua
 * Description: TODO
 * DateTime: 2024/11/5 10:58
 **/
@Namespace("top.primsnet.sync.business.datasource.mapper.MysqlDataSourceMapper")
public interface MysqlDataSourceMapper{
    List<GetDataSourceFieldsTO> getFields(@Param("tableName") String schemaName,@Param("tableName") String tableName);
}
