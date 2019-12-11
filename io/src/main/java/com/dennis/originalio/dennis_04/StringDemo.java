package com.dennis.originalio.dennis_04;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/**
 * 计算机是如何识别什么时候该把两个字节转换为一个中文呢?
 * 在计算机中中文的存储分两个字节：(GBK)
 * 		第一个字节肯定是负数。
 * 		第二个字节常见的是负数，可能有正数。但是没影响。
 * 在计算机中中文的存储分三个字节：(UTF-8)
 */
public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "ABCDEFG";
        String ss = "我爱你中国";

        byte[] bytes = s.getBytes();
        byte[] bytes1 = ss.getBytes();
        byte[] bytes2 = ss.getBytes("GBK");

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
    }
}
