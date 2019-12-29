package com.dennis.validator.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 描述：
 *
 * @author Dennis
 * @version 1.0
 * @date 2019/12/28 18:55
 */
@Data
@Accessors(chain = true)
public class Foo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @Range(min = 18L,max = 100L,message = "年龄范围错误")
    private Integer age;

    @Pattern(regexp = "^1(3|4|5|7|8|)\\d{9}$", message = "手机号格式错误")
    @NotBlank(message = "手机号不能为空")
    private String cellPhone;

    @Email(message = "邮箱格式错误")
    private String email;

}
