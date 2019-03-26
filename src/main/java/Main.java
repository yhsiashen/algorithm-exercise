import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.interrupted;

public class Main {

    static ReentrantLock lock =  new ReentrantLock();

     private static final Object monitor = new Object();

    static {
        int a = 1;
        System.out.println("a:"+a);

    }

    synchronized static void test(){

            System.out.println("test start ...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("test end ...");
        }
    }

    static class TestThread implements Runnable{

        @Override
        public void run() {
           synchronized (monitor){
               try {
                   monitor.wait();
                   System.out.println("wait方法不生效");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
    static class TestThread2 implements Runnable{

        @Override
        public void run() {
            synchronized (monitor){
                monitor.notify();
            }
        }
    }


    public static void main(String[] args) {

        Thread n1 = new Thread(new TestThread());
        Thread n2 = new Thread(new TestThread2());
        n1.start();
        n2.start();
//        n.interrupt();
    }
}
