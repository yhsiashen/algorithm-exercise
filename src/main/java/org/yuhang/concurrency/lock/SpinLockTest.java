package org.yuhang.concurrency.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用Atomic变量实现自旋锁
 * Created by chinalife on 2018/5/31.
 */
public class SpinLockTest {

    //自旋锁
    static class SpinLock {
        AtomicInteger state = new AtomicInteger(0);

        public void lock() {
            while (true) {
                if (state.get() == 1) {
                } else if (state.compareAndSet(0, 1)) {
                    break;
                }
            }
        }
        public void unlock() {
            state.set(0);
        }
    }

    private static int count;

    //线程总数
    private static int clinetTotal = 5000;

    //并发执行的线程数
    private static int threadTotal = 200;


    private final static SpinLock lock = new SpinLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clinetTotal);
        for (int i = 0; i < clinetTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count:"+count);
    }


    private static void add(){
        try {
            lock.lock();
            count++;
        }finally {
            lock.unlock();
        }

    }
}
