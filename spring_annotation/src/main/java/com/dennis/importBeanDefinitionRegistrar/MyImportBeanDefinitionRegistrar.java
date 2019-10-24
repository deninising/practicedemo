package com.dennis.importBeanDefinitionRegistrar;

import com.dennis.bean.Color;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        for (String annotation:annotationTypes){
            System.out.println(annotation);
        }
        boolean red = registry.containsBeanDefinition("com.dennis.bean.Red");
        boolean yellow = registry.containsBeanDefinition("com.dennis.bean.Yellow");
        if (red && yellow){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Color.class);
            registry.registerBeanDefinition("color",rootBeanDefinition);
        }
    }
}
