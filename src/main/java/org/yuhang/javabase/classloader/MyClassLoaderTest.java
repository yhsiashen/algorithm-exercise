package org.yuhang.javabase.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * JVM中的类由类的全限定名和类加载器共同决定唯一性
 */
public class MyClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader cl = new MyClassLoader("/Users/mac/Projects/class");
        YourClassLoader cly = new YourClassLoader("/Users/mac/class");

        try {
            Class c  = cl.loadClass("org.yuhang.Main");
            Class cy = cly.loadClass("org.yuhang.Main");
            System.out.println(c == cy);
            if(c!=null){
                Object obj = c.newInstance();
                Method method = c.getDeclaredMethod("test",null);
                System.out.println((String)method.invoke(obj,null));
            }
            if(cy!=null){
                Object obj = cy.newInstance();
                Method method = cy.getDeclaredMethod("test",null);
                System.out.println((String)method.invoke(obj,null));
            }
            Class cc = Class.forName("org.yuhang.Main",false,cly);
            System.out.println(cc==cy);

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
