package org.yuhang.concurrency.sync;

import java.util.Vector;

/**
 * Created by chinalife on 2018/5/26.
 */
public class VectorTest {

    private  volatile  static Vector<Integer> vector= new Vector<Integer>();

    public static void main(String[] args) {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i);
                }
            });
            thread1.start();
            thread2.start();
        }
    }
}
