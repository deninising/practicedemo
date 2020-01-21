package com.dennis.demo.loopwithexception;

import java.util.Arrays;
import java.util.List;

/**
 * 描述：针对于循环操作，会抛异常的情况下，如何选择
 *
 * @author Liaopeng
 * @version 1.0
 * @date 2020/1/20 11:10
 */
public class Demo {
    public static void main(String[] args) {
        List<Integer> srcNum = Arrays.asList(1, 3, 5, 10, 0, 4, 78, 0, 12, 78, 0, 11, 33, 0);

        srcNum.forEach(num -> {
            try {
                Integer r = 100 / num;
                System.out.println(r);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        System.out.println("=================================");
        try {
            for (Integer i : srcNum) {
                System.out.println(100 / i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
