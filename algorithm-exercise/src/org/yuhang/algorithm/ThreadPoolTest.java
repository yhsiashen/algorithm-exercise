package org.yuhang.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chinalife on 2018/3/25.
 */
public class ThreadPoolTest {

    static class Taskone implements Runnable{
        public void run() {
            System.out.println("线程名为:"+Thread.currentThread().getName()+"的线程  "+"任务1已执行");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Tasktwo implements Runnable{
        public void run(){
            System.out.println("线程名为:"+Thread.currentThread().getName()+"的线程  "+"任务2已执行");
        }
    }

    public static void main(String[] args) throws Exception {
        Taskone taskone = new Taskone();
        Tasktwo tasktwo = new Tasktwo();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(taskone);
        executor.execute(taskone);
        executor.execute(taskone);
        executor.execute(taskone);
        executor.execute(taskone);
        executor.execute(taskone);

//        executor.execute(tasktwo);
//        executor.execute(tasktwo);
    }
}
