package org.yuhang.concurrency.lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {

    private static final ReentrantLock lock = new ReentrantLock();

    private static int i = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int j = 0; j < 10; j++) {
            Future res = executor.submit(new MyTask());
            System.out.println(res.get());
        }
    }

    private static class MyTask implements Callable<Integer> {

        @Override
        public Integer call() {
            try {
                if(lock.tryLock(3, TimeUnit.SECONDS)) {//2s内获取到锁了，则执行任务，否则报超时..
                    i++;
                    System.out.println("线程：" + Thread.currentThread().getId() + ",i为:" + i);
                    Thread.sleep(1000);
                    return i;
                }else {
                    System.out.println("线程："+Thread.currentThread().getId()+"超时未获取到任务，返回...");
                    return 0;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            return 0;

        }
    }
}
