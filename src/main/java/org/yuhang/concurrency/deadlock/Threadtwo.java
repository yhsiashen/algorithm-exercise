package org.yuhang.concurrency.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Threadtwo implements Runnable{

    private ReentrantLock lock1;

    private ReentrantLock lock2;

    public Threadtwo(ReentrantLock lock1,ReentrantLock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock1.lock();
        System.out.println("threadtwo get lock1");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        lock2.unlock();
        lock1.unlock();
        System.out.println("threadtwo release lock1");
    }
}
