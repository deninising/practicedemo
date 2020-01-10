package com.dennis.demo.serialzdemo;

import lombok.Data;

@Data
public class Dog extends Animal {
    private String name;
    private Integer weight;
}
