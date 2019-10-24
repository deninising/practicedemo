package com.dennis.bean;

import com.dennis.config.MainConfig01;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfig01Test {
    private ApplicationContext applicationContext;

    @Before
    public void initApplicationContext(){
        applicationContext = new AnnotationConfigApplicationContext(MainConfig01.class);

    }

    @Test
    public void testMainConfig01(){
        System.out.println("容器创建完成......");
    }
}
