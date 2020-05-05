package com.dennis.config;

import com.dennis.bean.Person;
import com.dennis.filter.MyTypeFilter;
import com.dennis.service.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// 配置类 == 配置文件
@Configuration  // 告诉spring这是一个配置类
// 包扫描:
// value 指定要扫描的包，
// excludeFilters 指定要排除扫描的组件，
// includeFilters 指定只包含的组件,使用时必须禁用掉默认的组件扫描过滤器（全部扫描:useDefaultFilters = false）
// FilterType.ANNOTATION,classes = {Controller.class}:按照注解类扫描过滤
// FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}:按照类类型扫描过滤
// FilterType.CUSTOM:自定义组件扫描过滤（MyTypeFilter implements TypeFilter）过滤优先级最低
@ComponentScan(value = "com.dennis"
//        ,excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})}
        , includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
        useDefaultFilters = false
)
public class MainConfig {

    // 给容器中注入一个Bean，类型为返回值类型，id默认为方法名作为id,@Bean()中可以给Bean自定义id放弃默认id
//    @Bean(name = "zhangsan")
    @Bean
    public Person person() {
        return Person.builder().name("张三").age(20).build();
    }

}
