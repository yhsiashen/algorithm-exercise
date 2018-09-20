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
                System.out.println("get signal");
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            lock.lock();
            System.out.println("get lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println("send signal");
            lock.unlock();
        }).start();
    }
}
