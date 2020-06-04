package com.sxdx.springmvc.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: spring-all
 * @description: DogFactoryBean
 * @author: garnett
 * @create: 2020-04-02 10:25
 **/

public class DogFactoryBean implements FactoryBean<Dog> {
    @Override
    public Dog getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
