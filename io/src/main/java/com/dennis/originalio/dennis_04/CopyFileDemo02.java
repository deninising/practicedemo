package com.dennis.originalio.dennis_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class CopyFileDemo02 {
    public static void main(String[] args) throws Exception {
        // 封装数据源
        FileInputStream fis = new FileInputStream(new File("D:\\Github\\practicedemo\\io\\src\\main\\java\\com\\dennis\\originalio\\dennis_02\\FileOutPutStreamDemo01.java"));
        // 封装目的地
        FileOutputStream fos = new FileOutputStream(new File("fos05.txt"), true);

        int len;
        byte[] bytes = new byte[1024];

        while ((len = fis.read(bytes)) != -1) {
            System.out.println(len);
            fos.write(bytes);
        }
        // 释放资源(先关谁都行)
        fis.close();
        fos.close();
    }
}
