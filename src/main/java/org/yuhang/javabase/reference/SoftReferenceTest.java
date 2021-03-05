package org.yuhang.javabase.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用-可以
 */
public class SoftReferenceTest {

    private static class User{
        int[] num = new int[1000000];
    }

    public static void main(String[] args) {
        SoftReference<Object> softReference = new SoftReference<>(new User());
        System.out.println(softReference.get());
//        int[] num = new int[1000000];
        System.gc();
        System.out.println(softReference.get());
    }

}
