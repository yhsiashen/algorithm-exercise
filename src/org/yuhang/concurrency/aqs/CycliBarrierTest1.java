package org.yuhang.concurrency.aqs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设置CyclicBarrier时可以指定一个runnable线程，每到达一次计数器数目则执行这个runnable
 * Created by chinalife on 2018/5/27.
 */
public class CycliBarrierTest1 {

    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        System.out.println("callback is running");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        System.out.println(threadNum + "is ready");
        if (threadNum % 2 == 0)
            barrier.await();
        System.out.println(threadNum + "is continue");

    }
}
