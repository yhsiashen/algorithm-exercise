import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    static ReentrantLock lock =  new ReentrantLock();

    public synchronized static void test(){

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
           test();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
           Thread testThread = new Thread(new TestThread());
           testThread.start();
        }
    }
}
