package org.yuhang.concurrency.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chinalife on 2018/5/27.
 */
public class CycliBarrierTest {

    private static final CyclicBarrier barrier = new CyclicBarrier(5);

    private static final CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(()->{
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private static void  race(int threadNum) throws Exception{
        Thread.sleep(1000);
        System.out.println(threadNum+"is ready");
        if(threadNum == 0 || threadNum == 1|| threadNum == 2||threadNum == 3) {
            countDownLatch.countDown();
            countDownLatch.await();
        }
//        barrier.await();
        System.out.println(threadNum+"is continue");

    }
}
