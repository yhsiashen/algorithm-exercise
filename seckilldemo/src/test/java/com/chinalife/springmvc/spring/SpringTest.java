package com.chinalife.springmvc.spring;

import com.chinalife.springmvc.entity.Seckill;
import com.chinalife.springmvc.entity.SeckillFactoryPojo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yuhang on 2018/4/26.
 */
public class SpringTest {
    public static void main(String[] args) throws Exception {
        String path = "spring/spring-test.xml";
        ClassPathXmlApplicationContext cxac = new ClassPathXmlApplicationContext(path);
//        Seckill seckillVo = (Seckill) cxac.getBean("seckillVo");
        SeckillFactoryPojo seckillFactoryPojo = (SeckillFactoryPojo)cxac.getBean("seckillVoByFactory");
        Seckill seckillVo1 = (Seckill) seckillFactoryPojo.getObject();
        System.out.println(seckillVo1.getSeckillNumber());
//        System.out.println(seckillVo.getClass().getName());
//        System.out.println(seckillVo.getSeckillNumber());
    }
}
