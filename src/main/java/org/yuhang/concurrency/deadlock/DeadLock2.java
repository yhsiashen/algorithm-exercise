package org.yuhang.concurrency.deadlock;

import java.util.concurrent.locks.ReentrantLock;


/**
 * lock.lockInterruptibly()可响应线程中断，一定程度上避免死锁
 */
public class DeadLock2 {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    static class Thread1 implements Runnable{

        @Override
        public void run() {
            try {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lock();
                System.out.println("Thread1获取了lock2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }

        }
    }

    static class Thread2 implements Runnable{

        @Override
        public void run() {
            try {
                    lock2.lock();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
                System.out.println("Thread2获取了lock1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread n1 = new Thread(new Thread1());
        Thread n2 = new Thread(new Thread2());
        n1.start();
        n2.start();
        Thread.sleep(1000);
        n1.interrupt();

    }
}
