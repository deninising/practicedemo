package com.dennis.staticfactory;

import java.util.EnumSet;

public class Demo01 {
    public static void main(String[] args) {
        Boolean s = Boolean.valueOf(true);
        if (s){
            System.out.println("true");
        }
        Elvis.getInstance();
        Elvis.INSTANCE.print();
        System.out.println("我的名字是："+Elvis.INSTANCE.name);

        for (MyEnum color:MyEnum.values()){
            System.out.println(color+",ordinal:"+color.ordinal()+",name:"+color.name());
        }
    }
}
