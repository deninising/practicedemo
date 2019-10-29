package com.dennis.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean, ApplicationContextAware {

    private ApplicationContext appContext;

    public Cat() {
        System.out.println("Cat....Constructor....");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat....destroy....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat....init....");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }
}
