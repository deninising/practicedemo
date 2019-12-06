package com.dennis.pstmmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dennis.pstmmybatisplus.dao/**")
public class PstmmybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PstmmybatisplusApplication.class, args);
    }

}
