package top.primsnet.sync.business.datasource.to;

import lombok.Data;

/**
 * Author: joshua
 * Description: TODO
 * DateTime: 2024/8/8 19:07
 **/
@Data
public class CreateDataSourceStrTO {
    //类型
    private Integer type;
    //数据源bean名称
    private String beanName;
    //数据源链接
    private String url;
    //用户
    private String userName;
    //密码
    private String password;
    //装载状态
    private String loadStatus;


}
