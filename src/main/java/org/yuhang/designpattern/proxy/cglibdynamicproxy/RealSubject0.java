package org.yuhang.designpattern.proxy.cglibdynamicproxy;

/**
 * 真实类，用于测试CGLIB动态代理
 */
public class RealSubject0 {

    public void sayHello(String name){
        System.out.println("hello "+name);
    }
}
