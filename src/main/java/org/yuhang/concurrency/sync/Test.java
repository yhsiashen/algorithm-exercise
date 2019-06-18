package org.yuhang.concurrency.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        final SynchronizedTest2 st2 = new SynchronizedTest2();
        final SynchronizedTest2 st3 = new SynchronizedTest2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(st2::method1);
        executorService.execute(st3::method2);
        executorService.execute(st2::method3);


    }
}
