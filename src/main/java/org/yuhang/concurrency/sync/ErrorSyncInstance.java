package org.yuhang.concurrency.sync;

public class ErrorSyncInstance implements Runnable{

    final static Object monitor = new Object();

    static int i;

    public void add(){
        synchronized (monitor) {
            i++;
        }
    }

    @Override
    public void run() {
        for (int j = 0; j < 100000 ; j++) {
             add();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ErrorSyncInstance instance1 = new ErrorSyncInstance();
        ErrorSyncInstance instance2 = new ErrorSyncInstance();
        Thread n1 = new Thread(instance1);
        Thread n2 = new Thread(instance2);
        n1.start();
        n2.start();

        n1.join();
        n2.join();

        System.out.println(i);
    }
}
