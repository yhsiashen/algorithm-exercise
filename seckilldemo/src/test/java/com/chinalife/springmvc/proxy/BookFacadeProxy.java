package com.chinalife.springmvc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chinalife on 2018/2/8.
 */
public class BookFacadeProxy implements InvocationHandler{

     private Object target ;

     public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces()
        ,this);
     }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //调用业务方法前
        System.out.println("打印前面的日志");
        result = method.invoke(target,args);
        //调用业务方法后
        System.out.println("打印后面的日志");
        return null;
    }
}
