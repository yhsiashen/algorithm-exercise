package org.yuhang.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chinalife on 2018/5/10.
 */
public class Client {
    public static void main(String[] args) {
      dynamicProxy();
    }

    public static void dynamicProxy(){
        Subject realSubject =  new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), new InvocationSubject(realSubject));
        proxySubject.sayHello("yuhang");

    }
    static class InvocationSubject implements InvocationHandler{

        Subject target;

        public InvocationSubject(Subject subject) {
            target = subject;
        }

        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
            System.out.println("log : " + method.getName() + " invoked with " + args);
            return method.invoke(target, args);
        }
    }
    public String test(String s){
        return s+"111";
    }
}
