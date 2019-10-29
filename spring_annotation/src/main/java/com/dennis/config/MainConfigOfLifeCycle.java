package com.dennis.config;

import com.dennis.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期：bean创建--->初始化--->销毁
 * 容器管理管理bean的生命周期：
 * 我们可以自定义bean的生命周期方法：容器在bean进行到当前生命周期的时候会自动调用我们自定义的方法
 *
 * A:
 *      构造（对象创建）
 *          单实例：在容器启动的时候创建对象
 *          多实例：在获取bean实例的时候创建对象
 *
 *
 *
 * B:
 *      初始化：a.单实例：容器中该对象创建完成，并给属性赋好值后开始调用其对应的初始化方法
 *         b.多实例：容器创建完成，并手动调用一个bean时才执行
 *      销毁： a.单实例：容器关闭完成前调用对象的销毁方法
 *         b.多实例：容器关闭不会触发销毁方法,只能手动调用bean的销毁方法
 *      1）、指定bean的初始化和销毁方法：
 *           通过@Bean注解：指定init-method和destroy-method
 *      2）、初始化：让bean实现InitializingBean接口的afterPropertiesSet()方法:也就是在bean的属性赋值完成后将执行的初始化方法
 *           销毁：让bean实现DisposableBean(可丢弃bean)destroy()方法:也就是在ioc容器关闭前bean将执行的销毁方法
 *      3）、对象构造方法执行完成之后调用：@PostConstruct 标注在bean的方法上 JSR250标准
 *           容器销毁bean之前调用：@PreDestroy 标注在bean的方法上,容器销毁bean之前，JSR250标准
 *
 *
 *          BeanPostProcessor原理流程：
 *          populateBean(beanName, mbd, instanceWrapper); // 给bean进行赋值
 *
 *          initializebean
 *        {
 *          applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName)
 *          invokeInitMethods(beanName, wrappedBean, mbd) 初始化方法执行
 *          applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName)
 *        }
 *
 * C:
 *      4）、接口BeanPostProcessor:bean后处理器（初始化执行前调用postProcessBeforeInitialization（Object bean, String beanName），后调用postProcessAfterInitialization（Object bean, String beanName））
 */

@Configuration
@ComponentScan("com.dennis.bean")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
