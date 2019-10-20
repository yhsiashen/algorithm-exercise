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
        final Semaphore semaphore = new Semaphore(1,false);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    if(threadNum==10){
                        System.out.println("num=10时一个许可证被释放");
                        test(threadNum);
                        semaphore.release();
                        return;
                    }
                    //semaphore.tryAcquire(100,TimeUnit.MILLISECONDS
                       semaphore.acquire(); //线程一直阻塞，直到获取到1个许可证
                       System.out.println("当前许可证:"+semaphore.availablePermits());
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
        Thread.sleep(1000);
        System.out.println("threadNum:"+threadNum);

    }
}
