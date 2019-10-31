package com.dennis.config;


import com.dennis.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * 自动装配
 *      Spring利用依赖注入（DI）,完成ioc容器中各个组件的依赖关系的赋值
 *
 *   A: 1）、@Autowired：自动注入
 *          a、默认先安照类型去容器中找相应的组件，applicationContext.getbean(BookDao.class)
 *          b、若ioc容器中找到多个同类型的组件，则默认将属性名作为id进一步筛选出对象的组件并进行注入
 *                                      applicationContext.getbean("bookDao")
 *
 *     2）、@Qualifier（”bookDao02“）:使用该注解与@Autowired结合可以指定组件的id,放弃在多个同一类型的组件情况下默认将属性名作为id
 *
 *     3）、@Autowired（requred=false）:默认一定要注入成功（requred=true）否则报错，用该注解找得到对应的组件就注入，没有就拉倒
 *
 *     4）、@Primary:自动注入时，spring 默认首选的bean,也可以继续使用@Qualifier(”XXX“)手动指定，此时@Primary将失效
 *      BookService{
 *          @Autowired
 *          private BookDao bookDao;
 *      }
 *
 *   B: 1）、Spring还支持@Resource(JSR250)和@Inject(JSR330)[java规范]
 *
 *   @Resource(JSR250)：
 *      可以和@Aotuwired一样实现自动装配功能：默认按照属性名称注入
 *      也可以自动指定id注入：@Resource(name="XXX"),但是不能支持@Primary功能，和required=false/true属性
 *   @Inject(JSR330)
 *      需要导入jar包javax.inject:和@Autowired的功能一样能使用@Primary但是没有required=false/true属性赋值
 *   @Autowired :Spring的定义
 *   @Inject(JSR330) :JAVA规范
 *   @Resource(JSR250) :JAVA规范
 *
 *  C:
 *     @Autowired ：标在set方法上、标在构造器上、标在参数前、成员属性上都是从ioc容器中按类型获取相应的组件进行赋值
 *     1、【标在方法上】:@Bean+方法参数，参数会从容器中去自动获取对应组件实例并进行赋值注入（最常用）也可以默认不写@Aotuwired
 *     2、标在构造器上：如果组件类只有一个有参构造器，那么构造器上的@Aotuwired注解可以省略
 *     3、标在参数前
 *     4、成员属性上
 *
 *  D：
 *     自定义组件想要使用Spring容器底层的一些组件（ApplicationContext,BeanFactory,XXX）
 *     只需要自定义组件实实现 XXXAware接口并实现setXXX接口，那么在容器中创建该组件实例的时候
 *     回自动回调setXXX方法，完成组件注入到自定义Bean中去
 *     XXXAwire:功能使用XXXAwireProcessor 后置处理器在自定义初见初始化前后来回调实现的
 *     例如：ApplicationContextAwire====》ApplicationContextAwireProcessor
 */
@Configuration
@ComponentScan({"com.dennis.controller","com.dennis.service"
        ,"com.dennis.dao","com.dennis.bean"})
public class MainConfigDI {

    @Bean(value = "bookDao02")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLab("02");
        return bookDao;
    }

    @Primary
    @Bean
    public BookDao bookDao03(){
        BookDao bookDao = new BookDao();
        bookDao.setLab("03");
        return bookDao;
    }
}
