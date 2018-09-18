package com.chinalife.springmvc.multthread;

import java.util.concurrent.Callable;

/**
 * Created by chinalife on 2018/4/20.
 */
public class MyCallable implements Callable {
    private StringBuilder s;

    public MyCallable(StringBuilder s) {
        this.s = s;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    public Object call() throws Exception {
        System.out.println("线程名为:"+Thread.currentThread().getName()+"正在处理字符串:"+s.toString()+"....");
        return s.append("cccccccc").toString();
    }
}
