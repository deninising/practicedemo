package com.dennis.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 正被扫描到的类的读取器，可通过它获取当前被扫描类的类信息
        // 获取类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        // 获取类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 获取扫描到的类的类路径
        Resource resource = metadataReader.getResource();
        String description = resource.getDescription();
        System.out.println("当前类的.class文件的磁盘所在路径"+description);

        String className = classMetadata.getClassName();
        System.out.println("当前扫描到的类的类名--->"+className);

        // 满足条件，加入到容器中
        if (className.contains("er")){
            return true;
        }
        return false;
    }
}
