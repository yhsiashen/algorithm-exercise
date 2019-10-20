package org.yuhang.concurrency.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印零与奇偶数 LC1116
 */
public class ZeroEvenOdd {

    private int n;

    private int state; //打印状态

//    private boolean even; //是否打印奇数

//    private AtomicInteger i = new AtomicInteger(0);

    private final Lock lock = new ReentrantLock();

    private final Condition zore = lock.newCondition();
    private final Condition even = lock.newCondition();
    private final Condition odd = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero() throws InterruptedException {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                    while (state !=0) {
                        zore.await(); //不是自己打印时线程挂起等待
                    }
                    System.out.print(0);
                    if( (i % 2) == 0) {
                        state = 1;
                        zore.signalAll();
                    }else{
                        state = 2;
                        zore.signalAll();
                    }

                }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void even() throws InterruptedException {
        try {
            lock.lock();
            for (int i = 1; i < n; i+=2){
                while (state!=1) {
                    zore.await(); //不是自己打印时线程挂起等待
                }
                System.out.print(i);
                state = 0;
                zore.signalAll();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void odd() throws InterruptedException {
        try {
            lock.lock();
            for (int i = 2; i < n; i+=2){
                while (state!=2) {
                    zore.await(); //不是自己打印时线程挂起等待
                }
                System.out.print(i);
                state = 0;
                zore.signalAll();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(20);
        Thread n1= new Thread(()->{
            try {
                zeroEvenOdd.odd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread n2= new Thread(()->{
            try {
                zeroEvenOdd.zero();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread n3= new Thread(()->{
            try {
                zeroEvenOdd.even();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        n1.start();
        n2.start();
        n3.start();

        Thread.currentThread().join();

    }
}
