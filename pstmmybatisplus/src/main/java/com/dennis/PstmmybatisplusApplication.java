package com.dennis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.dennis.demo.dao/**"})
@SpringBootApplication
public class PstmmybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PstmmybatisplusApplication.class, args);
    }

}
