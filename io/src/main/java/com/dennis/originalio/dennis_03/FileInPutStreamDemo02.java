package com.dennis.originalio.dennis_03;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

/**
 * 字节输入流操作步骤：
 * A:创建字节输入流对象
 * B:调用read()方法读取数据，并把数据显示在控制台
 * C:释放资源
 *
 * 读取数据的方式：
 * A:int read():一次读取一个字节
 * B:int read(byte[] b):一次读取一个字节数组
 */
public class FileInPutStreamDemo02 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(new File("fos03.txt"));
//        int read = fis.read();
//        System.out.println((char) read);
//
//        int read1 = fis.read();
//        System.out.println((char) read1);

        byte[] bytes = new byte[1024];

        int len = fis.read(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println(len);
        System.out.println(new String(bytes,0,len));

        // 释放资源
        fis.close();
    }
}
