package com.dennis.bean;


import com.dennis.aop.MathCalculator;
import com.dennis.config.MainConfigAop;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigAopTest {
    private AnnotationConfigApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfigAop.class);
    }

    @Test
    public void tesMathCalculator() {
        MathCalculator calculator = applicationContext.getBean(MathCalculator.class);
        calculator.div(5, 0);
        applicationContext.close();
    }
}
