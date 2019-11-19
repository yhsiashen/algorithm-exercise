package org.yuhang.javabase.memoryleak;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MemoryLeak memoryLeak = new MemoryLeak();
        for (int i = 0; i < 10; i++) {
            executorService.submit(memoryLeak::test);
        }
        executorService.shutdown();
    }
}
