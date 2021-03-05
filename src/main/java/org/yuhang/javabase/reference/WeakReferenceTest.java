package org.yuhang.javabase.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用
 */
public class WeakReferenceTest {

    public static void main(String[] args) {
        WeakReference<Object> weakReference = new WeakReference<>(new Object());
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }
}
