package com.dennis.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑，返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值就是要导入的组件的全类名
    //AnnotationMetadata： 当前标注@Import类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.dennis.bean.Yellow"};
    }
}
