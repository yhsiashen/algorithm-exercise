package org.yuhang.javabase.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException {
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        String[] path = System.getProperty("java.class.path").split(":");
//        for(String p:path){
//            System.out.println(p);
//        }
//        System.out.println(AppClassLoaderTest.class.getClassLoader().toString());

        ClassLoader cl = AppClassLoaderTest.class.getClassLoader();
        Class c = cl.loadClass("org.yuhang.Main");
        try {
            Object obj = c.newInstance();
            Method method = c.getDeclaredMethod("test",null);
            System.out.println((String)method.invoke(obj,null));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
