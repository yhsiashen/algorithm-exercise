package org.yuhang.concurrency.threadpool;

import java.util.Date;
import java.util.concurrent.*;

public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        for (int i = 0; i <2 ; i++) {
            executor.scheduleAtFixedRate(() -> System.out.println("目前时间是:"+new Date() +";"+Thread.currentThread().getName() + "正在打印schedule任务.."), 1, 2, TimeUnit.SECONDS);
        }
    }



}
