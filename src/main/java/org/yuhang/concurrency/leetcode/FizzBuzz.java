package org.yuhang.concurrency.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzBuzz {

    private int n;

    private volatile int state = 4 ; //状态 1-fizz ,2-buzz, 3-fizzbuzz, 4-number

    public FizzBuzz(int n) {
        this.n = n;
    }

    private final Lock lock = new ReentrantLock();

    private final Condition fizz = lock.newCondition();



    // printFizz.run() outputs "fizz".
    public void fizz() throws InterruptedException {
        lock.lock();
        try {
            for (int i=1; i < n+1; i++) {
                while (state != 1){
                    fizz.await();
                }

//                printFizz.run();
                System.out.println("Fizz");
                state = 4;
                fizz.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz() throws InterruptedException {
        lock.lock();
        try {
            for (int i=1; i < n+1; i++) {
                while (state != 2){
                    fizz.await();
                }

//                printBuzz.run();
                System.out.println("Buzz");
                state = 4;
                fizz.signalAll();
            }

        }finally {
            lock.unlock();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz() throws InterruptedException {
        lock.lock();
        try {
            for (int i=1; i < n+1; i++) {
                while (state != 3){
                    fizz.await();
                }

//                printFizzBuzz.run();
                System.out.println("FizzBuzz");
                state = 4;
                fizz.signalAll();
            }

        }finally {
            lock.unlock();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number() throws InterruptedException {
        lock.lock();
        try {
            for (int i=1; i < n+1; i++) {
                while (state != 4){
                    fizz.await();
                }

                if(i%3==0 && i%5==0){
                    state = 3;
                    fizz.signalAll();
                }else if(i%3==0){
                    state = 1;
                    fizz.signalAll();
                }else if(i%5==0){
                    state = 2;
                    fizz.signalAll();
                }else {
//                    printNumber.accept(i);
                    System.out.println(i);
                }

            }

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
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
