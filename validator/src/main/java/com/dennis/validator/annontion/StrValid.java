package com.dennis.validator.annontion;


import com.dennis.validator.annontion.impl.StrValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 描述：
 *
 * @author Dennis
 * @version 1.0
 * @date 2019/12/29 15:08
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 指定此注解的实现，即:验证器
@Constraint(validatedBy = {StrValidator.class})
public @interface StrValid {
    // 当验证不通过时的提示信息
    String message() default "the string length does not meet requirement ";

    // 根据实际需求定的方法
    String minimumLength() default "";

    // 约束注解在验证时所属的组别
    Class<?>[] groups() default {};

    // 负载
    Class<? extends Payload>[] payload() default {};
}
