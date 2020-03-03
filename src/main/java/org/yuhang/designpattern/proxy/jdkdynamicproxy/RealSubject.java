package org.yuhang.designpattern.proxy.jdkdynamicproxy;

import org.yuhang.designpattern.proxy.jdkdynamicproxy.Subject;

/**
 * 真实类，用于测试JDK动态代理
 */
public class RealSubject implements Subject {
         public void sayHello(String name){
             System.out.println("hello:"+name);
         }
}
