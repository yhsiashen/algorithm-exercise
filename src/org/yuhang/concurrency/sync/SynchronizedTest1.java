package org.yuhang.concurrency.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chinalife on 2018/5/23.
 */
public class SynchronizedTest1 {
    
    public void test1(){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println("i:"+i);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SynchronizedTest1 synchronizedTest1 = new SynchronizedTest1();
        for (int i = 0; i < 3; i++) {
            executorService.execute(()->{
                synchronizedTest1.test1();
            });
        }

    }
}
