package org.yuhang.concurrency.leetcode;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 线程交替打印-阻塞队列实现 LC1115
 */
public class FooBar {

    private int n;

    private BlockingQueue<Integer> barQueue;
    private BlockingQueue<Integer> fooQueue;

    public FooBar(int n) {
        this.n = n;
        this.fooQueue = new ArrayBlockingQueue<>(1);
        try {
            fooQueue.put(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.barQueue = new ArrayBlockingQueue<>(1);
    }


    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
           fooQueue.take();//foo队列里有元素时才执行，为空则take时一直阻塞
           System.out.print("foo");
           barQueue.put(i); //foo执行完后给bar队列里加入元素

      }
    }

    public void bar() throws InterruptedException {
       for (int i = 0; i < n; i++) {
            barQueue.take(); //bar队列里有元素时才执行，为空则take时一直阻塞
            System.out.print("bar");
            fooQueue.put(i); //
      }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(10);
        Thread n1 = new Thread(() -> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        n1.start();
        Thread n2 = new Thread(() -> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        n2.start();
        Thread.currentThread().join();

    }


}


