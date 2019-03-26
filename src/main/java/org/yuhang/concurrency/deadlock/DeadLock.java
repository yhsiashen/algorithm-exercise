package org.yuhang.concurrency.deadlock;

import java.util.concurrent.locks.ReentrantLock;

/** 两线程相互等待对方释放资源，即为死锁
 * Created by chinalife on 2018/5/30.
 */
public class DeadLock implements Runnable {

    private static int flag;

    private static final Object o1 = new Object(),o2 = new Object();

    private static final ReentrantLock lock1 = new ReentrantLock();

    private static final ReentrantLock lock2 = new ReentrantLock();

    @Override
    public void run() {
        System.out.println("flag:"+flag);
        if(flag ==1 ){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }

        if(flag == 2){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (o1){
                    System.out.println("0");
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
          ReentrantLock lock1 = new ReentrantLock();
          ReentrantLock lock2 = new ReentrantLock();
          Threadone r1 = new Threadone(lock1,lock2);
          Threadtwo r2 = new Threadtwo(lock1,lock2);
          new Thread(r1).start();
          new Thread(r2).start();


    }
}
