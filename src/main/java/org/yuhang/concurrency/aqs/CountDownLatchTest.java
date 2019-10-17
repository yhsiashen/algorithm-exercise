package org.yuhang.concurrency.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by chinalife on 2018/5/26.
 */
public class CountDownLatchTest {
    //线程数
    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    if(threadNum == 50 || threadNum == 51) {
                        countDownLatch.countDown();
                        countDownLatch.await(4, TimeUnit.SECONDS); //设超时时间
                    }
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await(2, TimeUnit.SECONDS); //设超时时间
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        System.out.println("threadNum:"+threadNum);
        Thread.sleep(100);
    }
}
