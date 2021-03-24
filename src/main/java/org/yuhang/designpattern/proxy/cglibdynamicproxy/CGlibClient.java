//package org.yuhang.designpattern.proxy.cglibdynamicproxy;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
//public class CGlibClient {
//
//    static class MyMethodInterceptor  implements MethodInterceptor{
//
//        RealSubject0 realSubject0;
//
//        public MyMethodInterceptor(Object obj){
//            realSubject0 = (RealSubject0)obj;
//        }
//
//        @Override
//        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//            System.out.println("before hello ....");
//            Object obj = method.invoke(realSubject0,objects);
//            System.out.println("after hello ...");
//            return obj;
//        }
//    }
//
//    public static void main(String[] args) {
//        dynamicProxy();
//    }
//
//    public static void dynamicProxy(){
//        RealSubject0 realSubject0 = new RealSubject0();
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(realSubject0.getClass());
//        enhancer.setCallback(new MyMethodInterceptor(realSubject0));
//        RealSubject0 proxy = (RealSubject0) enhancer.create();
//        proxy.sayHello("yuhang");
//        System.out.println(proxy.getClass().getName());
//
//    }
//
//}
