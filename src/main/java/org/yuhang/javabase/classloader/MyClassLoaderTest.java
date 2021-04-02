package org.yuhang.javabase.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader cl = new MyClassLoader("/Users/mac/Projects/class/lib");

        try {
            Class c  = cl.loadClass("org.yuhang.Main");
            if(c!=null){
                Object obj = c.newInstance();
                Method method = c.getDeclaredMethod("test",null);
                System.out.println((String)method.invoke(obj,null));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
