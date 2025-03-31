package top.prism.sync.business.module.syncbaseconfig.vo;

import lombok.Data;

@Data
public class FieldBindTO {

    private String fromFieldName;
    private String fromFieldType;
    private String fromFieldAnnotation;
    private String toFieldName;
    private String toFieldType;
    private String toFieldAnnotation;
}
