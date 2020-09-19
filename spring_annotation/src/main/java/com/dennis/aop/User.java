package com.dennis.aop;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private String userName;

    private String userAge;

    private List<String> bobbies;

}
