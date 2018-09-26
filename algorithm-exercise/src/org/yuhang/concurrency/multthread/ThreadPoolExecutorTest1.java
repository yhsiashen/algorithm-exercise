package org.yuhang.concurrency.multthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by chinalife on 2018/5/27.
 */
public class ThreadPoolExecutorTest1 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            executorService.schedule(()->{
//                System.out.println("schedule run1");
//            },3, TimeUnit.SECONDS);
//        }
        for (int i = 0; i < 10; i++) {
            executorService.scheduleAtFixedRate(() -> {
                System.out.println("schedule run2");
            }, 1, 3, TimeUnit.SECONDS);
        }
    }
}
