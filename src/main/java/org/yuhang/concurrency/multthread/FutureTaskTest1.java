package org.yuhang.concurrency.multthread;

import java.util.concurrent.*;

public class FutureTaskTest1 {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(()->{
//            int i = 1/0;
//        });
        // 对于submit()方法，若submit中定义的Runable或Callable类的run方法中有异常
        // 则只会在调用FutureTask.get()方法时才会抛出！！！

//        Future<?> futureRes = executorService.submit(()->{
//            int i = 1/0;
//            System.out.println("12");
//        });
//        try {
//            System.out.println(futureRes.get());
//        } catch (InterruptedException e) {
//            System.out.println("InterruptedException exception!");
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            System.out.println("Execution exception!");
//            e.printStackTrace();
//        }
        try {
            String futureRes1 = executorService.submit(() -> {
                 int i =1/0;
                 return String.valueOf(i);
             }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
