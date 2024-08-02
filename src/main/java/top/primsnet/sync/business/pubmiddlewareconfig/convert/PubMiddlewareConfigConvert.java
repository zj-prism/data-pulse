package top.primsnet.sync.business.pubmiddlewareconfig.convert;

import top.primsnet.sync.business.pubmiddlewareconfig.entity.PubMiddlewareConfig;
import top.primsnet.sync.business.pubmiddlewareconfig.vo.PubMiddlewareConfigReqVO;
import top.primsnet.sync.business.pubmiddlewareconfig.vo.PubMiddlewareConfigResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* @author joshua
* @since 2024-08-02 09:34:40
*/
@Mapper
public interface PubMiddlewareConfigConvert{

    PubMiddlewareConfigConvert INSTANCE = Mappers.getMapper(PubMiddlewareConfigConvert.class);

    PubMiddlewareConfig convert(PubMiddlewareConfigReqVO reqVO);
    PubMiddlewareConfigResVO convert(PubMiddlewareConfig reqVO);
    List<PubMiddlewareConfigResVO> convert(List<PubMiddlewareConfig> reqVO);
}



