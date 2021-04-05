package org.yuhang.concurrency.multthread;

public class MaxThreadTest {

    private static Object object = new Object();
    private static int count = 0;

    public static void main(String[] args) {


        for(;;) {
            new Thread(() ->{
                synchronized (object){
                    count+=1;
                    System.out.println("new thread #"+count);
                }
                for(;;){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
