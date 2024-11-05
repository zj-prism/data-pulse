package top.primsnet.sync.business.datasource.load;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Inject;
import org.noear.solon.core.event.AppLoadEndEvent;
import org.noear.solon.core.event.EventListener;
import top.primsnet.sync.business.datasource.service.DataSourceServiceContext;
import top.primsnet.sync.business.datasource.to.CreateDataSourceStrTO;
import top.primsnet.sync.business.module.pubdatasourceconfig.service.PubDataSourceConfigService;
import top.primsnet.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigReqVO;
import top.primsnet.sync.business.module.pubdatasourceconfig.vo.PubDataSourceConfigResVO;
import top.primsnet.sync.common.enums.DataSourceTypeEnum;
import top.primsnet.sync.common.exception.ServiceException;

import java.util.List;

@Slf4j
@Component
public class AppLoadEndEventImpl implements EventListener<AppLoadEndEvent> {
    @Inject
    private PubDataSourceConfigService pubDataSourceConfigService;
    @Inject
    DataSourceServiceContext dataSourceServiceContext;

    /**
     * 启动自动加载已装载的数据源
     * @param event
     * @throws Throwable
     */
    @Override
    public void onEvent(AppLoadEndEvent event) {
        try {
            PubDataSourceConfigReqVO reqVO = new PubDataSourceConfigReqVO();
            reqVO.setLoadStatus("1");
            List<PubDataSourceConfigResVO> list = pubDataSourceConfigService.list(reqVO);
            for (PubDataSourceConfigResVO entity : list) {
                if (ObjUtil.isEmpty(entity)){
                    throw new ServiceException("加载数据源失败,数据源配置不存在,请重新配置数据源");
                }
                Integer type = entity.getType();
                DataSourceTypeEnum dataSourceTypeEnum = DataSourceTypeEnum.getByValue(type);
                if (ObjUtil.isEmpty(dataSourceTypeEnum)){
                    throw new ServiceException("当前数据源未兼容");
                }
                CreateDataSourceStrTO dataSourceStrTO = new CreateDataSourceStrTO();
                BeanUtil.copyProperties(entity,dataSourceStrTO);
                dataSourceStrTO.setBeanName(entity.getName());
                //加载数据源
                String dataSourceStr = dataSourceServiceContext.getService(dataSourceTypeEnum.getRemark()).createDataSourceStr(dataSourceStrTO);
                //加载数据源
                dataSourceServiceContext.getService(dataSourceTypeEnum.getRemark()).initDataSource(entity.getName(),dataSourceStr);
            }
        } catch (ServiceException e) {
            log.error("启动时加载数据源已装载数据源失败：{}", ExceptionUtil.stacktraceToString(e));
        }
    }
}