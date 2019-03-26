package org.yuhang.algorithm.designpattern.reflect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chinalife on 2018/5/10.
 */
public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String className = reader.readLine();
        String methodName = reader.readLine();
        Class clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName);
        try {
            System.out.println(method.invoke(clazz.newInstance()));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(method.toString());

    }
}
