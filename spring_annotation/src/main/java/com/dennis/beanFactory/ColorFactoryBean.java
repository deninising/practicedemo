package com.dennis.beanFactory;

import com.dennis.bean.Color;
import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return Color.builder().name("复合颜色").build();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // 控制是否时单例 true则为单例bean false为多例bean
    @Override
    public boolean isSingleton() {
        return true;
    }
}
