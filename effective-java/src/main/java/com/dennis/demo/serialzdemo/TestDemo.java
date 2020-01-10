package com.dennis.demo.serialzdemo;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestDemo {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog();
        dog.setName("小白");
        dog.setWeight(55);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("E:\\dog.txt"));
        objectOutputStream.writeObject(dog);
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("E:\\dog.txt"));
//        Object object = objectInputStream.readObject();
//        System.out.println(object);

    }
}
