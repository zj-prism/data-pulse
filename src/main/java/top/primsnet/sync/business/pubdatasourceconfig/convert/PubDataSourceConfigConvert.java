package top.primsnet.sync.business.pubdatasourceconfig.convert;

import top.primsnet.sync.business.pubdatasourceconfig.entity.PubDataSourceConfig;
import top.primsnet.sync.business.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.primsnet.sync.business.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* @author joshua
* @since 2024-07-23 22:20:29
*/
@Mapper
public interface PubDataSourceConfigConvert{

    PubDataSourceConfigConvert INSTANCE = Mappers.getMapper(PubDataSourceConfigConvert.class);

    PubDataSourceConfig convert(PubDataSourceConfigReqVO reqVO);
    PubDataSourceConfigResVO convert(PubDataSourceConfig reqVO);
    List<PubDataSourceConfigResVO> convert(List<PubDataSourceConfig> reqVO);
}



