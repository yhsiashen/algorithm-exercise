package com.chinalife.springmvc.entity;

import org.springframework.beans.factory.FactoryBean;

import java.util.Date;

/**
 * Created by chinalife on 2018/4/26.
 */
public class SeckillFactoryPojo implements FactoryBean{


    public Object getObject() throws Exception {
        return new Seckill(12378L,"asd",123,new Date(),new Date(),new Date());
    }


    public Class<?> getObjectType() {
        return null;
    }


    public boolean isSingleton() {
        return false;
    }
}
