package top.primsnet.sync.business.module.synctableconfig.convert;

import top.primsnet.sync.business.module.synctableconfig.entity.SyncTableConfig;
import top.primsnet.sync.business.module.synctableconfig.vo.SyncTableConfigReqVO;
import top.primsnet.sync.business.module.synctableconfig.vo.SyncTableConfigResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* Author joshua
* @since 2024-12-27 14:02:16
*/
@Mapper
public interface SyncTableConfigConvert{

    SyncTableConfigConvert INSTANCE = Mappers.getMapper(SyncTableConfigConvert.class);

    SyncTableConfig convert(SyncTableConfigReqVO reqVO);
    SyncTableConfigResVO convert(SyncTableConfig reqVO);
    List<SyncTableConfigResVO> convert(List<SyncTableConfig> reqVO);
}



