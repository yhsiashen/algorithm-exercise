package org.yuhang.concurrency.aqs;

import java.util.concurrent.*;

/**
 * Created by chinalife on 2018/5/26.
 */
public class SemaphoreTest {
    //线程数
    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3,false);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    //semaphore.tryAcquire(100,TimeUnit.MILLISECONDS
                       semaphore.acquire();
                       test(threadNum);
                       semaphore.release();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("主程序结束...");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        Thread.sleep(2000);
        System.out.println("threadNum:"+threadNum);

    }
}
