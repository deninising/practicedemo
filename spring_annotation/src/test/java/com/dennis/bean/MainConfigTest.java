package com.dennis.bean;

import com.dennis.config.MainConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigTest {
    private ApplicationContext applicationContext = null;

    @Before
    public void init(){
        applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
    }

    @Test
    public void testPerson(){
        Object zhangsan = applicationContext.getBean(Person.class);
        System.out.println(zhangsan);
//        Object person = applicationContext.getBean(Person.class);
//        System.out.println(person);
//        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
//
//        for(String beanTypeName:beanNamesForType){
//            System.out.println(beanTypeName);
//        }
    }

    @Test
    public void testComponentScan(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames){
            System.out.println("componentName="+beanName);
        }
    }

}
