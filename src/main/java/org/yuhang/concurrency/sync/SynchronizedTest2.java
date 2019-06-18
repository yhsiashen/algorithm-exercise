package org.yuhang.concurrency.sync;

/**
 * synchronized关键字测试类
 * created by yuhang on 2019/06/12
 */
public class SynchronizedTest2 {

    private final static Object MOINTOR = new Object();

    public synchronized void method1(){

            System.out.println("this is method1...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public synchronized void method2(){
        System.out.println("this is method2...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }

    public void method3(){
        synchronized (this){
            System.out.println("this is method3...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
