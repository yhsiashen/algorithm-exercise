package org.yuhang.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by chinalife on 2018/5/23.
 */
public class AtomicTest2 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    private static AtomicInteger count1 = new AtomicInteger(3);

    public static void main(String[] args) {
//        count.compareAndSet(0,2);
//        count.compareAndSet(0,1);
//        count.compareAndSet(1,3);
//        count.compareAndSet(2,4);
//        count.compareAndSet(3,5);
//        System.out.println("count:"+count.get());

//        System.out.println(count1.incrementAndGet());
        count1.compareAndSet(3,2);
        System.out.println(count1.get());
    }
}
