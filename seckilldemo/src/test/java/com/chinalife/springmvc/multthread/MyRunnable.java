package com.chinalife.springmvc.multthread;

/**
 * Created by chinalife on 2018/4/18.
 */
public class MyRunnable implements Runnable {
    private String s;

    public MyRunnable(){
        super();
    }

    public MyRunnable(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        System.out.println("线程名为:"+Thread.currentThread().getName()+"正在处理字符串:"+s+"....");
//        printArg(s);
    }
    public void printArg(String s){
        System.out.println(s);
    }
}
