package com.dennis.config;

import com.dennis.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig01 {


    /**
     * Specifies the name of the scope to use for the annotated component/bean.
     * <p>Defaults to an empty string ({@code ""}) which implies
     * ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
     * @since 4.2
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     * #value
     *
     * prototype: 多实例的：ioc容器启动时并不会创建一个对象到容器中，每次主动获取一个bean时
     *                    容器才会调用方法创建一个新实例对象
     *
     * singleton: 单例：ioc容器启动就会创建一个实例对象到容器中，每次获取bean时将会返回同一
     *                 实例对象(默认为饿汉式加载单例bean使用@lazy可实现懒汉式加载单例 bean)
     *
     * request: 同一次请求创建一个实例
     *
     * sessesion: 同一给sessesion创建一个实例
     */
//    @Scope(value = "prototype")
//    @Scope(value = "singleton") // 默认为饿汉式加载单例bean
    @Bean("zhaoshi")
    @Lazy // 可实现懒汉式加载单例bean:创建容器时并不创建单例bean,涉及到调用对象时才创建单例bean
    public Person person(){
        System.out.println("给容器中添加person实例对象");
        return Person.builder().age(31).name("赵四").build();
    }
}
