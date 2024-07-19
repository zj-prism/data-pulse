package top.primsnet.sync.config.doc;

import com.github.xiaoymin.knife4j.solon.extension.OpenApiExtensionResolver;
import io.swagger.models.Scheme;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.docs.DocDocket;
import org.noear.solon.docs.models.ApiContact;
import org.noear.solon.docs.models.ApiInfo;

import javax.xml.transform.Result;

@Configuration
public class DocConfig {

    private final static String BASE_PATE="top.primsnet.sync.business";

    // knife4j 的配置，由它承载
    @Inject
    OpenApiExtensionResolver openApiExtensionResolver;

    /**
     * 简单点的
     */
    @Bean("allApi")
    public DocDocket allApi() {
        //根据情况增加 "knife4j.setting" （可选）
        return new DocDocket()
                .basicAuth(openApiExtensionResolver.getSetting().getBasic())
                .vendorExtensions(openApiExtensionResolver.buildExtensions())
                .groupName("全部接口")
                .schemes(Scheme.HTTP.toValue())
                .apis(BASE_PATE);

    }
}