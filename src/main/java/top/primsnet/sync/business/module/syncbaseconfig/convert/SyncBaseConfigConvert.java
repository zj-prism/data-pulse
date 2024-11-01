package top.primsnet.sync.business.module.syncbaseconfig.convert;

import top.primsnet.sync.business.module.syncbaseconfig.entity.SyncBaseConfig;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigReqVO;
import top.primsnet.sync.business.module.syncbaseconfig.vo.SyncBaseConfigResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* Author joshua
* @since 2024-11-01 17:40:38
*/
@Mapper
public interface SyncBaseConfigConvert{

    SyncBaseConfigConvert INSTANCE = Mappers.getMapper(SyncBaseConfigConvert.class);

    SyncBaseConfig convert(SyncBaseConfigReqVO reqVO);
    SyncBaseConfigResVO convert(SyncBaseConfig reqVO);
    List<SyncBaseConfigResVO> convert(List<SyncBaseConfig> reqVO);
}



