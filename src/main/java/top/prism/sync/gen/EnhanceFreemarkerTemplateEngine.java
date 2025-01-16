package top.prism.sync.gen;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.generator.config.builder.CustomFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器支持自定义[DTO\VO等]模版
 */
public class EnhanceFreemarkerTemplateEngine extends FreemarkerTemplateEngine {


    @Override
    protected void outputCustomFile(@NotNull List<CustomFile> customFiles, @NotNull TableInfo tableInfo, @NotNull Map<String, Object> objectMap) {
        String entityName = tableInfo.getEntityName();
        String entity = (String) objectMap.get("entity");
        if (StrUtil.isNotBlank(entity)){
            objectMap.put("Entity",StrUtil.sub(entity,0,1).toLowerCase()+StrUtil.sub(entity,1,entity.length()));
        }
        customFiles.forEach((item) -> {
            String fileName = String.format( item.getFilePath()+item.getPackageName() +entityName + "%s", item.getFileName());
            this.outputFile(new File(fileName), objectMap, item.getTemplatePath(),true);
        });
    }


}