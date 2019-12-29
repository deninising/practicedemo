package com.dennis.validator.annontion.impl;

import com.dennis.validator.annontion.StrValid;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 描述：
 *
 * @author Dennis
 * @version 1.0
 * @date 2019/12/29 15:28
 */
public class StrValidator implements ConstraintValidator<StrValid, Object> {
    /**
     * 校验边界
     */
    private String minimumLength;


    /**
     * 初始化方法， 在执行isValid 方法前，会先执行此方法
     *
     * @param constraintAnnotation 注解信息模型，可以从该模型中获取注解类中定义的一些信息，如默认值等
     * @date 2019/1/19 11:27
     */
    @Override
    public void initialize(StrValid constraintAnnotation) {
        System.out.println(constraintAnnotation.minimumLength());
        this.minimumLength = constraintAnnotation.minimumLength();
    }

    /**
     * 校验的具体逻辑实现
     * <p>
     * 注: 此方法可能会并发执行，需要根据实际情况看否是需要保证 线程安全
     *
     * @param value   被自定义注解所标注的对象的 值
     * @param context Provides contextual data and operation when applying a given constraint validator.
     * @return 校验是否通过
     * @date 2019/1/19 11:30
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        if (value instanceof String) {
            int length = ((String) value).length();
            return length >=Integer.parseInt(this.minimumLength);
        }
        return false;
    }
}
