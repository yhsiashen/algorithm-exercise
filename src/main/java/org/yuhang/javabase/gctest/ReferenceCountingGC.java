package org.yuhang.javabase.gctest;

public class ReferenceCountingGC {

    public Object instance = null;

    private static  final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC A = new ReferenceCountingGC();
        ReferenceCountingGC B = new ReferenceCountingGC();
        A.instance = B;
        B.instance = A;

        A=null;
        B=null;

        System.gc();
    }
}
