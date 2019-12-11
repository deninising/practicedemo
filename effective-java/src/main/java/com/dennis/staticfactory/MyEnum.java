package com.dennis.staticfactory;

public enum MyEnum {
    RED, BLACK, YELLOW, WHITE;

    public static void get() {
        System.out.println(RED);
    }

}
