package org.yuhang.javabase.objectheader;

import org.openjdk.jol.info.ClassLayout;

/**
 * 输出对象头的字节码
 */
public class ObjectHeaderTest {

    public static void main(String[] args) {
       Object obj = new Object();
        synchronized (obj) {
             System.out.println(obj.hashCode());
             System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
//        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
