package com.dennis.originalio.dennis_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节输出流操作步骤：
 * A:创建字节输出流对象
 * B:调用write()方法
 * C:释放资源
 *
 * public void write(int b):写一个字节
 * public void write(byte[] b):写一个字节数组
 * public void write(byte[] b,int off,int len):写一个字节数组的一部分
 */
public class FileOutPutStreamDemo02 {
    public static void main(String[] args) throws IOException {
        /*
         * 创建字节输出流对象了做了几件事情：
         * A:调用系统功能去创建文件
         * B:创建fos对象
         * C:把fos对象指向这个文件
         */
        File file = new File("fos02.txt");
        FileOutputStream fos = new FileOutputStream(file);
        // 写一个字节
//        fos.write(97); // a的ASCLL码值
//        fos.write(65); // A的ASCLL码值
//        fos.write(48); // 0的ASCLL码值

        //public void write(byte[] b):写一个字节数组
        byte[] bytes = {97,98,99,100,101,102,103};
//        fos.write(bytes);

        //public void write(byte[] b,int off,int len):写一个字节数组的一部分
        fos.write(bytes,1,4);

        //释放资源
        fos.close();

    }
}
