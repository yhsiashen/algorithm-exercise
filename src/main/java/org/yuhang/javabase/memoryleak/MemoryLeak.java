package org.yuhang.javabase.memoryleak;


public class MemoryLeak {

    public static BigSize bigSize;

    public void test(){
            bigSize = new BigSize();
            System.out.println("线程:"+Thread.currentThread().getName()+"正在执行...bi地址为:"+bigSize);
            while (true){

            }
    }
}
