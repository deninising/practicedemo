package com.dennis.bean;

import com.dennis.config.MainConfigDI;
import com.dennis.dao.BookDao;
import com.dennis.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainConfigDITest {
    private AnnotationConfigApplicationContext applicationContext;

    @Before
    public void init(){
        applicationContext = new AnnotationConfigApplicationContext(MainConfigDI.class);
    }

    @Test
    public void testAutowire(){
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

        BookDao bookDao= (BookDao) applicationContext.getBean("bookDao02");
        System.out.println(bookDao);
    }
}
