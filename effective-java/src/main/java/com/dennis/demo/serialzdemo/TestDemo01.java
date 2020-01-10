package com.dennis.demo.serialzdemo;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestDemo01 {
    public static void main(String[] args) throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E://dog.txt"));

        Object object = objectInputStream.readObject();
        System.out.println(object);
    }
}
