package com.dennis.config;

import com.dennis.bean.*;
import com.dennis.beanFactory.ColorFactoryBean;
import com.dennis.condition.LinuxCondition;
import com.dennis.condition.WindowsCondition;
import com.dennis.importBeanDefinitionRegistrar.MyImportBeanDefinitionRegistrar;
import com.dennis.importselector.MyImportSelector;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 标在配置类上，则需要当前conditionl.match()返回true,该配置类的所有注册bean才生效
@Conditional(WindowsCondition.class)
@Configuration
@Import({Red.class, Blue.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})// id默认的是类的全限定名
public class MainConfig02 {


    @Bean("zhangsan")
    public Person person(){
        return Person.builder().name("张三").age(55).build();
    }

    // 该条件类的match方法返回true则注册该bean
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person windowsFather(){
        return Person.builder().age(66).name("bill").build();
    }

    // 该条件类的match方法返回true则注册该bean
    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person linuxFather(){
        return Person.builder().age(68).name("linus").build();
    }

    /**
     * 给容器中导入注册组件
     * 1）、扫描包+组件标注注解（@Controller/@Service/@Reponsitory/@Component）
     * 2）、@Bean[导入第三方包里面的组件]
     * 3）、@import[快速给容器中导入一个组件]
     *      a、@Import(要导入的组件类对象) id 默认的时类的全限定名
     *      b、ImportSelector:返回需要导入的组件的全限定类名数组 组件id 默认的时类的全限定名
     *      c、ImportBeanDefinitionRegistrar:实现该接口，自定义逻辑调用
     *      beanDefinetionRegister.registerBeanDefinition()方法注册bean（可以自定义bean的id名）
     * 4）、FactoryBean实现接口，自定义一个返回指定类型的bean工厂
     *       注意：  // 通过IOC容器对工厂bean进行获取对象时操作时，调用的是自定义实现的getObject()方法返回的对象
     *              // 若想获取factorybean对象实例则在id前面加&符号
     */

    @Bean("colorFactoryBean")
    public FactoryBean beanFactory(){
        return new ColorFactoryBean();
    }

}
