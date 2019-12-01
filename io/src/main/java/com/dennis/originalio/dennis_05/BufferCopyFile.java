package com.dennis.originalio.dennis_05;

import java.io.*;
/*
 * 通过定义数组的方式确实比以前一次读取一个字节的方式快很多，所以，看来有一个缓冲区还是非常好的。
 * 既然是这样的话，那么，java开始在设计的时候，它也考虑到了这个问题，就专门提供了带缓冲区的字节类。
 * 这种类被称为：缓冲区类(高效类)
 * 写数据：BufferedOutputStream
 * 读数据：BufferedInputStream
 *
 * 构造方法可以指定缓冲区的大小，但是我们一般用不上，因为默认缓冲区大小就足够了。
 *
 * 为什么不传递一个具体的文件或者文件路径，而是传递一个OutputStream对象呢?
 * 原因很简单，字节缓冲区流仅仅提供缓冲区，为高效而设计的。但是呢，真正的读写操作还得靠基本的流对象实现。
 *
 * 注意：虽然我们有两种方式可以读取，但是，请注意，这两种方式针对同一个对象在一个代码中只能使用一个。
 */
public class BufferCopyFile {
    public static void main(String[] args) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("E:\\资料\\案例总汇\\java基础学习资料\\ebook\\图解HTTP-上野 & 宣.pdf")));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("copy.pdf")));

        int len;
        byte[] bytes = new byte[1024];

        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();


    }
}
