package com.dennis.originalio.dennis_02;

import java.io.File;
import java.io.FileOutputStream;

/*
 * 如何实现数据的换行?
 * 		为什么现在没有换行呢?因为你值写了字节数据，并没有写入换行符号。
 * 		如何实现呢?写入换行符号即可呗。
 * 		刚才我们看到了有写文本文件打开是可以的，通过windows自带的那个不行，为什么呢?
 * 		因为不同的系统针对不同的换行符号识别是不一样的?
 * 		windows:\r\n
 * 		linux:\n
 * 		Mac:\r
 * 		而一些常见的个高级记事本，是可以识别任意换行符号的。
 *
 * 如何实现数据的追加写入?
 * 		用构造方法带第二个参数是true的情况即可
 */
public class FileOutPutStreamDemo03 {
    public static void main(String[] args) throws Exception {
        File file = new File("fos03.txt");
        FileOutputStream fos03 = new FileOutputStream(file,true);
        String java = "java";

        for (int i = 0; i < 10; i++) {
            fos03.write(java.getBytes());
            fos03.write("\r\n".getBytes());
        }

        fos03.close();
    }
}
