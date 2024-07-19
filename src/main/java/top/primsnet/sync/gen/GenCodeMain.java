package top.primsnet.sync.gen;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenCodeMain {
    public static void main(String[] args){
        List<String> tables=new ArrayList<>();
        String author="joshua";
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入需要生成的表名，多张表用英文逗号隔开：");
        System.out.println(help);
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                String[] split = ipt.split(",");
                tables = Convert.toList(String.class, split);
            }
        }else {
            throw new MybatisPlusException("请输入正确的表名！");
        }
        String projectName="primsnet";
        for(String table:tables ){
            // 使用 FastAutoGenerator 快速配置代码生成器
            FastAutoGenerator.create("jdbc:sqlite:./src/main/resources/db/datapulse.db", "", "")

                    .globalConfig(builder -> {
                        builder.author(author) // 设置作者
                                .outputDir("src\\main\\java")
                                .enableSwagger()
                                .commentDate(DatePattern.NORM_DATETIME_PATTERN)
                        ; // 输出目录
                    })
                    .packageConfig(builder -> {
                        builder.parent("top."+projectName+".sync.business").moduleName(table.replace("_","")) // 设置父包名
                                .entity("entity")// 设置实体类包名
                                .mapper("mapper") // 设置 Mapper 接口包名
                                .service("service") // 设置 Service 接口包名
                                .serviceImpl("service.impl") // 设置 Service 实现类包名
                                .xml("mapper.xml"); // 设置 Mapper XML 文件包名
                    })
                    .strategyConfig(builder -> {
                        builder.addInclude(table) // 设置需要生成的表名
                                .entityBuilder().enableFileOverride()
                                .enableLombok()// 启用 Lombok
                                .enableFileOverride()
                                .enableTableFieldAnnotation() // 启用字段注解
                                .controllerBuilder() // 启用 REST 风格
                                .enableRestStyle()
                                .serviceBuilder().enableFileOverride().serviceTemplate("/templates/service.java").convertServiceFileName((tableName) -> tableName + "Service").serviceImplTemplate("/templates/serviceImpl.java")
                                .controllerBuilder().template("/templates/controller.java").enableFileOverride()
                                .mapperBuilder().enableBaseResultMap().enableFileOverride().mapperXmlTemplate("/templates/mapper.xml");
                    })
                    .injectionConfig(consumer -> {
                        List<CustomFile> customFile = new ArrayList<>();
                        CustomFile reqVO=new CustomFile.Builder().filePath("src/main/java/").packageName("top/primsnet/sync/business/"+table.replace("_","")+"/vo/").fileName("ReqVO.java").templatePath("/templates/req.java.ftl").build();
                        customFile.add(reqVO);
                        CustomFile resVO=new CustomFile.Builder().filePath("src/main/java/").packageName("top/primsnet/sync/business/"+table.replace("_","")+"/vo/").fileName("ResVO.java").templatePath("/templates/res.java.ftl").build();
                        customFile.add(resVO);
                        CustomFile mapstruct=new CustomFile.Builder().filePath("src/main/java/").packageName("top/primsnet/sync/business/"+table.replace("_","")+"/convert/").fileName("Convert.java").templatePath("/templates/convert.ftl").build();
                        customFile.add(mapstruct);
                        consumer.customFile(customFile);
                    })
                    .templateEngine(new EnhanceFreemarkerTemplateEngine())

                    // 使用 Freemarker 模板引擎
                    .execute(); // 执行生成
        }

    }
}