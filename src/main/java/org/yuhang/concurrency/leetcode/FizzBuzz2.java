package org.yuhang.concurrency.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FizzBuzz2 {
    private int n;
    private volatile int state = -1;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    public FizzBuzz2(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz() throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {   //只输出3的倍数(不包含15的倍数)
            if (i % 15 == 0)	//15的倍数不处理，交给fizzbuzz()方法处理
                continue;
            lock.lock();
            while (state != 3) {
                cond.await();
            }
//            printFizz.run();
            System.out.println("Fizz");
            state = -1;	//控制权交还给number()方法
            cond.signalAll();	//全体起立
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz() throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {   //只输出5的倍数(不包含15的倍数)
            if (i % 15 == 0)	//15的倍数不处理，交给fizzbuzz()方法处理
                continue;
            lock.lock();
            while (state != 5) {
                cond.await();
            }
//            printBuzz.run();
            System.out.println("Buzz");
            state = -1;	//控制权交还给number()方法
            cond.signalAll();	//全体起立
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz() throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {   //只输出15的倍数
            lock.lock();
            while (state != 15) {
                cond.await();
            }
//            printFizzBuzz.run();
            System.out.println("FizzBuzz");
            state = -1;	//控制权交还给number()方法
            cond.signalAll();	//全体起立
            lock.unlock();

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number() throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            lock.lock();
            while (state != -1) {
                cond.await();
            }
            if (i % 3 != 0 && i % 5 != 0) {
//                printNumber.accept(i);
                System.out.println(i);
            } else {
                if (i % 15 == 0)
                    state = 15;	//交给fizzbuzz()方法处理
                else if (i % 5 == 0)
                    state = 5;	//交给buzz()方法处理
                else
                    state = 3;	//交给fizz()方法处理

                cond.signalAll();	//全体起立
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FizzBuzz2 fizzBuzz = new FizzBuzz2(15);
        new Thread(()->{
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
