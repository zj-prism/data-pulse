package top.prism.sync.business.datasource.to;

import lombok.Data;

/**
 * Author:  joshua
 * Description: TODO
 * DateTime: 2024/11/5 10:25
 **/
@Data
public class GetDataSourceFieldsTO {

    //字段
    private String fieldName;

    //字段注释
    private String fieldAnnotation;

    //字段类型
    private String fieldType;
}
