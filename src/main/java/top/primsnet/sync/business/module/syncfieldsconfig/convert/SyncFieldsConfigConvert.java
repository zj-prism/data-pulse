package top.primsnet.sync.business.module.syncfieldsconfig.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import top.primsnet.sync.business.module.syncfieldsconfig.entity.SyncFieldsConfig;
import top.primsnet.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigReqVO;
import top.primsnet.sync.business.module.syncfieldsconfig.vo.SyncFieldsConfigResVO;

import java.util.List;
/**
*
*
* Author joshua
* @since 2024-11-01 17:41:40
*/
@Mapper
public interface SyncFieldsConfigConvert{

    SyncFieldsConfigConvert INSTANCE = Mappers.getMapper(SyncFieldsConfigConvert.class);

    SyncFieldsConfig convert(SyncFieldsConfigReqVO reqVO);
    SyncFieldsConfigResVO convert(SyncFieldsConfig reqVO);
    List<SyncFieldsConfigResVO> convert(List<SyncFieldsConfig> reqVO);
    List<SyncFieldsConfig> convertAll(List<SyncFieldsConfigReqVO> reqVO);
}



