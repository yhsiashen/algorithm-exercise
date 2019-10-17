package org.yuhang.concurrency.leetcode;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 控制线程按既定顺序执行 LC1114
 */
public class ProblemCountDownLatch {


    public static class Foo {
        private CountDownLatch countDownLatchA;
        private CountDownLatch countDownLatchB;

        public Foo() {
            countDownLatchA = new CountDownLatch(1);
            countDownLatchB = new CountDownLatch(1);
        }

        public void first() throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            Thread.sleep(10);
            System.out.println("first");
            countDownLatchA.countDown();
        }

        public void second() throws InterruptedException {
            countDownLatchA.await();
            Thread.sleep(10);
            // printSecond.run() outputs "second". Do not change or remove this line.
            System.out.println("second");
            countDownLatchB.countDown();
        }

        public void third() throws InterruptedException {
            countDownLatchB.await();
//            Thread.sleep(1000);
            // printThird.run() outputs "third". Do not change or remove this line.
            System.out.println("third");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(1); //计数器为1
        Foo foo = new Foo();
        for (int i = 0; i < 1; i++) {
            executorService.execute(() -> {
                try {
                    foo.second();
                    System.out.println("thread:"+Thread.currentThread().getName()+"正在调用SECOND方法");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executorService.execute(() -> {
                try {
                    foo.first();
                    System.out.println("thread:"+Thread.currentThread().getName()+"正在调用FIRST方法");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


            executorService.execute(() -> {
                try {
                    foo.third();
                    System.out.println("thread:"+Thread.currentThread().getName()+"正在调用THIRD方法");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}


