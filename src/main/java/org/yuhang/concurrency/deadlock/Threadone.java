package org.yuhang.concurrency.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Threadone implements Runnable {

    private ReentrantLock lock1;

    private ReentrantLock lock2;

    public Threadone(ReentrantLock lock1,ReentrantLock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock2.lock();
        System.out.println("threadone get lock2");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        lock1.unlock();
        lock2.unlock();
        System.out.println("threadone release lock2");
    }
}
