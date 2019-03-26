package org.yuhang.concurrency;

import java.util.concurrent.RecursiveTask;

/**
 * fork/join 框架
 * Created by chinalife on 2018/5/27.
 */
public class ForkJoinTaskTest extends RecursiveTask<Integer> {
    @Override
    protected Integer compute() {
        return null;
    }

    public static void main(String[] args) {

        if(   test() && 1==0){
            System.out.println("success");
        }
    }

    private static boolean test(){
        System.out.println("test");
        return true;
    }
}
