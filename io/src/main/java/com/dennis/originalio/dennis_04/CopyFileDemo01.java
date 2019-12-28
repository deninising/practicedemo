package com.dennis.originalio.dennis_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 复制文本文件。
 *
 * 数据源：从哪里来
 * FileOutPutStreamDemo01.java	--	读取数据	--	FileInputStream
 *
 * 目的地：到哪里去
 * fos04.txt	--	写数据		--	FileOutputStream
 *
 * java.io.FileNotFoundException: a.txt (系统找不到指定的文件。)
 *
 * 这一次复制中文没有出现任何问题，为什么呢?
 * 上一次我们出现问题的原因在于我们每次获取到一个字节数据，就把该字节数据转换为了字符数据，然后输出到控制台。
 * 而这一次呢?确实通过IO流读取数据，写到文本文件，你读取一个字节，我就写入一个字节，你没有做任何的转换。
 * 它会自己做转换。
 */
public class CopyFileDemo01 {
    public static void main(String[] args) throws Exception {
        // 封装数据源
        FileInputStream fis = new FileInputStream(new File("D:\\Github\\practicedemo\\io\\src\\main\\java\\com\\dennis\\originalio\\dennis_02\\FileOutPutStreamDemo01.java"));
        // 封装目的地
        FileOutputStream fos = new FileOutputStream(new File("fos04.txt"), true);

        int result;
        // 一次读一个人字节
        while ((result = fis.read()) != -1) {
            fos.write(result);
        }
        // 释放资源(先关谁都行)
        fis.close();
        fos.close();
    }
}
