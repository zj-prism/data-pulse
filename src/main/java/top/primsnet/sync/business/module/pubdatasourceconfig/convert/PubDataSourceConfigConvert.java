package top.primsnet.sync.business.module.pubdatasourceconfig.convert;

import top.primsnet.sync.business.module.pubdatasourceconfig.entity.PubDataSourceConfig;
import top.primsnet.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.primsnet.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* @author joshua
* @since 2024-07-30 14:30:12
*/
@Mapper
public interface PubDataSourceConfigConvert{

    PubDataSourceConfigConvert INSTANCE = Mappers.getMapper(PubDataSourceConfigConvert.class);

    PubDataSourceConfig convert(PubDataSourceConfigReqVO reqVO);
    PubDataSourceConfigResVO convert(PubDataSourceConfig reqVO);
    List<PubDataSourceConfigResVO> convert(List<PubDataSourceConfig> reqVO);
}



