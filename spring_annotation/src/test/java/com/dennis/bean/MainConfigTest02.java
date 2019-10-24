package com.dennis.bean;

import com.dennis.config.MainConfig02;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigTest02 {
    private ApplicationContext applicationContext;

    @Before
    public void initApplicationContext(){
        applicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
    }

    @Test
    public void testMainConfig02(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames){
            System.out.println("容器中含有bean--->"+beanName);
        }
    }

    @Test
    public void testImporAnnotation() throws Exception {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames){
            System.out.println("容器中含有bean--->"+beanName);
        }
        // 工厂bean获取对象时，调用的时自定义实现的getObject()方法返回的对象
        Object colorInstance = applicationContext.getBean("colorFactoryBean");
        System.out.println(colorInstance);
        // 若想获取factorybean对象实例则在id前面加&符号
        Object factorybean = applicationContext.getBean("&colorFactoryBean");
        System.out.println(factorybean);

    }
}
