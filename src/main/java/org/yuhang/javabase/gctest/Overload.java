package org.yuhang.javabase.gctest;


/**
 * 重载测试
 */
public class Overload {

    public static void sayHello(Object arg){
        System.out.println("hello Object "+arg);
    }

    public static void sayHello(char arg){
        System.out.println("hello char "+arg);
    }

    public static void sayHello(int arg){
        System.out.println("hello int "+arg);
    }

    public static void sayHello(long arg){
        System.out.println("hello long "+arg);
    }

    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Women extends Human{

    }

    public void sayHello(Human guy){
        System.out.println("hello guy!");
    }

    public void sayHello(Man man){
        System.out.println("hello man!");
    }

    public void sayHello(Women women){
        System.out.println("hello women!");
    }


    public static void main(String[] args) {
//        sayHello('a');
        Overload overload = new Overload();
        Human man = new Man();
        Human women = new Women();
        overload.sayHello(new Man());
        overload.sayHello(women);

    }
}
