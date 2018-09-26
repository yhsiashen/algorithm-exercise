package org.yuhang.concurrency.lock;

import org.yuhang.annotation.ThreadUnsafe;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by chinalife on 2018/5/23.
 */
@ThreadUnsafe
public class ReentrantlockTest {

    //线程总数
    public static int clinetTotal = 5000;

    //并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;

    // 构造参数为true是公平所，false是非公平锁，默认为非公平锁
    private static final Lock lock = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clinetTotal);
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < clinetTotal; i++) {
            blockingQueue.add(() -> {
                      add();
                    }
            );
        }
        System.out.println(blockingQueue.size());

        for (int i = 0; i < clinetTotal; i++) {
            executorService.execute(blockingQueue.poll());
        }
//        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count:" + count);
    }

    private static void add() {
        lock.lock();
        try {
            System.out.println("线程：" + Thread.currentThread().getName() + "获得了lock锁");
            count++;
        } finally {
            lock.unlock();
        }

    }
}
