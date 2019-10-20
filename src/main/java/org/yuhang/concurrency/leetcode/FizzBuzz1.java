package org.yuhang.concurrency.leetcode;

import java.util.concurrent.Semaphore;

public class FizzBuzz1 {

    private int n;
    Semaphore sa = new Semaphore(1);
    Semaphore sb = new Semaphore(1);
    Semaphore sc = new Semaphore(1);
    Semaphore sd = new Semaphore(1);
    private int cur = 1;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz() throws InterruptedException {
        while(true) {
            sa.acquire();
            if (cur > n)
                break;
            System.out.print("fizz ");
            sd.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz() throws InterruptedException {
        while(true) {
            sb.acquire();
            if (cur > n)
                break;
//            printBuzz.run();
            System.out.print("buzz ");
            sd.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz() throws InterruptedException {
        while (true) {
            sc.acquire();

            if (cur > n)
                break;
            System.out.print("fizzbuzz ");
            sd.release();
        }
    }

// printNumber.accept(x) outputs "x", where x is an integer.
        public void number () throws InterruptedException {
            while (true) {
                if (cur % 3 != 0 && cur % 5 != 0) {
//                    printNumber.accept(cur);
                    System.out.print(cur+" ");
                } else if (cur % 3 == 0 && cur % 5 != 0) {
                    sa.release();
                    sd.acquire();
                } else if (cur % 5 == 0 && cur % 3 != 0) {
                    sb.release();
                    sd.acquire();
                } else {
                    sc.release();
                    sd.acquire();
                }
                cur++;
                if (cur > n) {
                    sa.release();
                    sb.release();
                    sc.release();
                    break;
                }
            }

        }

    public static void main(String[] args) {
        FizzBuzz1 fizzBuzz = new FizzBuzz1(15);
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
