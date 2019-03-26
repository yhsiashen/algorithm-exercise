package org.yuhang.algorithm.designpattern.proxypattern;

/**
 * Created by chinalife on 2018/5/10.
 */
public class RealSubject implements Subject {
         public void sayHello(String name){
             System.out.println("hello:"+name);
         }
}
