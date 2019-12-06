package com.dennis.staticfactory;

import java.util.HashMap;

public enum Elvis {
    INSTANCE;

    public String name = "zhangsan";

    public static void getInstance() {
        System.out.println("huoqushili");
    }

    public void print() {
        System.out.println("我是一个单例对象的方法");
    }
}
