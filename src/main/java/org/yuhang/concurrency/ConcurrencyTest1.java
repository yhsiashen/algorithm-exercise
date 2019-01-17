package org.yuhang.concurrency;



import java.util.concurrent.*;

/**
 * Created by chinalife on 2018/6/8.
 */
public class ConcurrencyTest1 {

    static final Semaphore semaphore = new Semaphore(30);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(20));
//        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(100);
//        new Thread(()->{
        for (int i = 0; i < 100; i++) {
            try {
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        }).start();
        System.out.println("线程池开始执行任务..." + blockingQueue.size());
        while (true) {
            threadPoolExecutor.execute(() -> {
                try {
                    if(semaphore.tryAcquire(100,TimeUnit.MILLISECONDS)) {
                        System.out.println("线程名为：" + Thread.currentThread().getName() + "正在打印数据..." + blockingQueue.take());
                        semaphore.release(30);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

        }


    }
}
