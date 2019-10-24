package com.dennis.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取该IOC容器的bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 获取该容器中用于注册bean的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        // 获取程序的运行环境信息
        Environment environment = context.getEnvironment();

        String systemName = environment.getProperty("os.name");

        if (systemName.contains("Linux")){
            return true;
        }
        return false;
    }
}
