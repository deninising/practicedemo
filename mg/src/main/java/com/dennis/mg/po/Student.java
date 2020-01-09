package com.dennis.mg.po;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.lang.annotation.Documented;

/**
 * 描述：
 *
 * @author Liaopeng
 * @version 1.0
 * @date 2020/1/3 14:50
 */
@Data
@Accessors(chain = true)
@Document(value = "student")
public class Student implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    private String id;

    private String name;

    private String sex;

    private String introduce;

}
