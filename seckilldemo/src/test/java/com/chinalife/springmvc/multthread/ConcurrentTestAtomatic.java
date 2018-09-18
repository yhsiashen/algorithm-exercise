package com.chinalife.springmvc.multthread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chinalife on 2018/4/24.
 */
public class ConcurrentTestAtomatic {

//    private static volatile AtomicInteger i= new AtomicInteger(0);

    private static volatile int i ;

    private static Object addmonitor = new Object();

    private static void add(){
//        Object o  = new Object();
//        synchronized (addmonitor) {
            i++;
//        }
    }
    private static int add(int i){
        return ++i;
    }

//    private  class MyThreadOne extends  Thread{
//        public  void run() {
//            for (int j = 0; j < 10000; j++)
////                      i.incrementAndGet();
//                synchronized (addmonitor) {
//                    add();
//                }
//
//        }
//    }
//
//    private static class MyThreadTWO extends  Thread{
//        public  void run(){
//            for (int j = 0; j < 10000; j++)
////                    i.incrementAndGet();
//                synchronized (addmonitor) {
//                    add();
//                }
//        }
//    }

    public static void main(String[] args) throws InterruptedException {
        final Object o = new Object();
        final int l=0;
        new Thread(){
//            private Object threadOneMonitor = new Object();
             @Override
              public void run() {
                  for (int j = 0; j < 10000; j++)
//                      i.incrementAndGet();
                      synchronized (o) {
                           add(l);
                       }
              }
        }.start();


        new Thread(){
//            private Object threadTwoMonitor = new Object();
            public  void run(){
                    for (int j = 0; j < 10000; j++)
//                    i.incrementAndGet();
                        synchronized (o) {
                            add();
                        }
            }
        }.start();

//        MyThreadOne myThreadOne = new MyThreadOne();
//        MyThreadTWO myThreadTWO = new MyThreadTWO();

//        myThreadOne.start();
//        myThreadTWO.start();
//
//        myThreadOne.join();
//        myThreadTWO.join();

        System.out.println("i="+i);
        for (String s: args) {
            System.out.println("s::"+s);
        }
    }
}
