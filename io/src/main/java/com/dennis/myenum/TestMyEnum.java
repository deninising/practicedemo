package com.dennis.myenum;

public class TestMyEnum {
    public static void main(String[] args) {
        System.out.println(MyEnum.CATALOG.getValue());

        MyEnum menu = MyEnum.valueOf("MENU");
        System.out.println(menu.getValue());

        MyEnum[] values = MyEnum.values();
        System.out.println(values[1].name());
    }

}
