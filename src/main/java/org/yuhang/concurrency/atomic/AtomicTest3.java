package org.yuhang.concurrency.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by chinalife on 2018/5/23.
 */
public class AtomicTest3 {
    private static AtomicIntegerFieldUpdater<AtomicTest3> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicTest3.class,"count");
    public volatile int count = 100;

    public static void main(String[] args) {


    }
}
