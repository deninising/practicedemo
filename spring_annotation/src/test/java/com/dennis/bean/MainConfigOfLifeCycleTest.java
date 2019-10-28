package com.dennis.bean;

import com.dennis.config.MainConfigOfLifeCycle;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainConfigOfLifeCycleTest {

    private AnnotationConfigApplicationContext applicationContext = null;

    @Before
    public void init() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成......");
    }


    @Test
    public void testInitAndDestroy(){
       applicationContext.close();
    }

}
