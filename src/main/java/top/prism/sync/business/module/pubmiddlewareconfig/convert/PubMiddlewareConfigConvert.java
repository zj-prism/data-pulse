package top.prism.sync.business.module.pubmiddlewareconfig.convert;

import top.prism.sync.business.module.pubmiddlewareconfig.entity.PubMiddlewareConfig;
import top.prism.sync.business.module.pubmiddlewareconfig.vo.PubMiddlewareConfigReqVO;
import top.prism.sync.business.module.pubmiddlewareconfig.vo.PubMiddlewareConfigResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* Author joshua
* @since 2024-08-02 09:34:40
*/
@Mapper
public interface PubMiddlewareConfigConvert{

    PubMiddlewareConfigConvert INSTANCE = Mappers.getMapper(PubMiddlewareConfigConvert.class);

    PubMiddlewareConfig convert(PubMiddlewareConfigReqVO reqVO);
    PubMiddlewareConfigResVO convert(PubMiddlewareConfig reqVO);
    List<PubMiddlewareConfigResVO> convert(List<PubMiddlewareConfig> reqVO);
}



