package com.dennis.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class Dog {

    public Dog() {
        System.out.println("Dog....Constructor....");
    }

    // JDK1.8以上需手动导依赖
    // <dependency>
    //		<groupId>javax.annotation</groupId>
    //		<artifactId>javax.annotation-api</artifactId>
    //		<version>1.3.2</version>
    //	</dependency>
    @PostConstruct
    public void init(){
        System.out.println("Dog....init....");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog....destroy....");
    }
}
