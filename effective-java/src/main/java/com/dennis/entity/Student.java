package com.dennis.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Accessors(chain = true)
public class Student implements Serializable {
    private String name;
    private Integer age;
    private String gender;
    private Date birth;
}
