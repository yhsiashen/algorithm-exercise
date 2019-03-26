package org.yuhang.concurrency.lock;

public class WaitAndNotifyTest {

    private static final Object monitor = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (monitor){
                System.out.println("执行wait方法");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("得到锁");
                }
            }
        }).start();


        new Thread(()->{
            synchronized (monitor){
                System.out.println("执行notifyall方法");
                monitor.notifyAll();
            }
        }).start();
    }
}
