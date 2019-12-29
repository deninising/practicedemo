package com.dennis.validator.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * SpringMVC统一异常处理
 * 注:@ControllerAdvice为Controller层增强器,其只能处理Controller层抛出的异常;
 * 由于代码间的层级调用机制  、异常的处理机制等,所以这里处理Controller层的异常,就相当于
 * 处理了全局异常
 * <p>
 * 注: @RestControllerAdvice等同于  @ResponseBody 加上 @ControllerAdvice
 *
 * @author JustryDeng
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 具体的处理异常的逻辑
     * 注:@ExceptionHandler的value属性指定要处理哪些异常;
     *
     * @param e 捕获到的异常
     * @return 返回给前端的data
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public Map<String, Object> globalExceptionHandleMethod(Exception e) {
        Map<String, Object> resultMap = new HashMap<>(8);
        HashMap<String, String> validateErrorMsgMap = new HashMap<>();
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            BindingResult bindingResult = ex.getBindingResult();
            List<FieldError> errors = bindingResult.getFieldErrors();
            errors.forEach(error -> {
                validateErrorMsgMap.put(error.getField(), error.getDefaultMessage());
            });
        } else if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            constraintViolations.forEach(cV -> {
                String fieldName = ((PathImpl) cV.getPropertyPath()).getLeafNode().getName();
                validateErrorMsgMap.put(fieldName, cV.getMessage());
            });
        }
        resultMap.put("code", "400");
        resultMap.put("errors", validateErrorMsgMap);
        log.error("参数传递错误！");
        return resultMap;
    }
}