package top.primsnet.sync.business.module.pubdatasourceconfig.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.primsnet.sync.business.datasource.to.GetDataSourceFieldsTO;
import top.primsnet.sync.business.module.pubdatasourceconfig.entity.PubDataSourceConfig;
import top.primsnet.sync.common.mybatis.MyBaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * Author joshua
 * @since 2024-07-30 14:30:12
 */
@Mapper
public interface PubDataSourceConfigMapper extends MyBaseMapper<PubDataSourceConfig> {


    List<GetDataSourceFieldsTO> getFields(@Param("tableName") String tableName);
}
