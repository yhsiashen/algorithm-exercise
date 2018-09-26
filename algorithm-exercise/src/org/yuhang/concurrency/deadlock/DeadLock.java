package org.yuhang.concurrency.deadlock;

/** 两线程相互等待对方释放资源，即为死锁
 * Created by chinalife on 2018/5/30.
 */
public class DeadLock implements Runnable {

    private static int flag;

    private static Object o1 = new Object(),o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag:"+flag);
        if(flag ==1 ){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }

        if(flag == 0){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (o1){
                    System.out.println("0");
                }
            }
        }

    }

    public static void main(String[] args) {
          DeadLock d1= new DeadLock();
          DeadLock d2 = new DeadLock();
          d1.flag = 1;
          d2.flag = 0;
          new Thread(d1).start();
          new Thread(d2).start();

    }
}
