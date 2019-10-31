package com.dennis.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// 1、标在set方法上
// 2、标在构造器上：如果组件类只有一个有参构造器，那么构造器上的@Aotuwired注解可以省略
// 3、标在参数前
// 4、成员属性上
@Component
public class Boss {
    //    @Autowired
    private Car car;

    public Boss() {
        super();
    }

    @Autowired
    public Boss(Car car) {
        this.car = car;
    }


    public Car getCar() {
        return car;
    }


    //    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
