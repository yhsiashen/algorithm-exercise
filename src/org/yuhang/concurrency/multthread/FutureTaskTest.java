package org.yuhang.concurrency.multthread;

import java.util.concurrent.*;

/**
 * Created by chinalife on 2018/5/27.
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "done";
            }
        });

        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("线程开始执行....");
        executorService.execute(futureTask);
        String result = futureTask.get();
        System.out.println(result);
    }
}
