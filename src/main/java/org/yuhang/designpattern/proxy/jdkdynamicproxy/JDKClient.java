package org.yuhang.designpattern.proxy.jdkdynamicproxy;

import org.yuhang.designpattern.proxy.jdkdynamicproxy.RealSubject;
import org.yuhang.designpattern.proxy.jdkdynamicproxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** jdk动态代理实现
 * Created by chinalife on 2018/5/10.
 */
public class JDKClient {

    static class InvocationSubject implements InvocationHandler{

        Subject target;

        public InvocationSubject(Subject subject) {
            target = subject;
        }

        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {
//            System.out.println("log : " + method.getName() + " invoked with " + args);
            System.out.println(test("before"));
            Object obj =  method.invoke(target, args);
            System.out.println(test("after"));
            return obj;
        }
    }
    public static void main(String[] args) {
      dynamicProxy();
    }

    public static void dynamicProxy(){
        Subject realSubject =  new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), new InvocationSubject(realSubject));
        proxySubject.sayHello("yuhang");

    }

    public static String test(String s){
        return s+"111";
    }
}
