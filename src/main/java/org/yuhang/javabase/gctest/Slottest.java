package org.yuhang.javabase.gctest;


/**
 * 局部变量表引用局部变量导致不可被回收
 */
public class Slottest {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
//            placeholder = null;
        }

        System.gc();
    }
}
