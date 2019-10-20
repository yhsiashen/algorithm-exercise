package org.yuhang.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chinalife on 2018/5/27.
 */
public class ConditionTest {

    private static final Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("wait signal");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("get signal & release lock");
                lock.unlock();
            }
        }).start();

        for (int i = 0; i <40 ; i++) {
            new Thread(() -> {
                lock.lock();
                System.out.println("Thread:" + Thread.currentThread() + " get lock...");
                System.out.println("send signal");
                condition.signalAll();
                lock.unlock();
            }).start();
        }
    }
}
