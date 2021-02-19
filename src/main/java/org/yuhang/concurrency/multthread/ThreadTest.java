package org.yuhang.concurrency.multthread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 起线程的三种方式,继承Thread，实现Runnable，实现Callable
 */
public class ThreadTest {

    public static class MyThread extends Thread{

    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {

        }
    }

    public static class MyCallable implements Callable<String>{


        @Override
        public String call() throws Exception {
            return null;
        }
    }

    public static void main(String[] args) {
        Thread n1 =  new MyThread();
        n1.start();
        Thread n2 =  new Thread(new MyRunnable());
        n2.start();
        Thread n3 =  new Thread(new FutureTask<String>(new MyCallable()));
        n3.start();
    }

}
