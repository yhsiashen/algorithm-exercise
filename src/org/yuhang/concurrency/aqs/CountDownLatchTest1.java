package org.yuhang.concurrency.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by chinalife on 2018/5/26.
 */
public class CountDownLatchTest1 {
    //线程数
    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        //调用counDownLach.await方法的线程会在countDownLatch的线程数执行完
        //或者等待一定时间后不再阻塞调用线程。
        countDownLatch.await(10,TimeUnit.MICROSECONDS);
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        System.out.println("threadNum:"+threadNum);
        Thread.sleep(100);
    }
}
