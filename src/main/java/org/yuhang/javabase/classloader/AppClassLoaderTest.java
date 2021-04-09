package org.yuhang.javabase.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException {
//        System.out.println(System.getProperty("sun.boot.class.path"));
        String[] path = System.getProperty("sun.boot.class.path").split(":");
        for(String p:path){
            System.out.println(p);
        }
//        System.out.println(AppClassLoaderTest.class.getClassLoader().toString());


    }
}
