package com.dennis.config;

import com.dennis.aop.LogAspects;
import com.dennis.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 三步：
 *      1）、将业务逻辑类和切面类多以组件的方式注入到容器中，并用@Aspect标注切面类
 *      2）、在切面类的每一个通知方法都加上通知注解：并采用切入点表达式配置目标方法（告诉spring该通知何时执行）
 *      3）、配置类上开启基于注解的aop模式：@EnableAspectJAutoProxy
 *
 */

@Configuration
@EnableAspectJAutoProxy
public class MainConfigAop {

    // 业务逻辑类加入到容器
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    // 切面类加入到容器
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
