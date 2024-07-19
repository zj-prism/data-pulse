package top.primsnet.sync.business.fdtaskbaseconfig.convert;

import top.primsnet.sync.business.fdtaskbaseconfig.entity.FdTaskBaseConfig;
import top.primsnet.sync.business.fdtaskbaseconfig.vo.FdTaskBaseConfigReqVO;
import top.primsnet.sync.business.fdtaskbaseconfig.vo.FdTaskBaseConfigResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
*
*
* @author joshua
* @since 2024-07-18
*/
@Mapper
public interface FdTaskBaseConfigConvert{

    FdTaskBaseConfigConvert INSTANCE = Mappers.getMapper(FdTaskBaseConfigConvert.class);

    FdTaskBaseConfig convert(FdTaskBaseConfigReqVO reqVO);
    FdTaskBaseConfigResVO convert(FdTaskBaseConfig reqVO);
    List<FdTaskBaseConfigResVO> convert(List<FdTaskBaseConfig> reqVO);
}



