package org.yuhang.algorithm.rowtooffer;

/** 斐波拉切数列的第n项
 * Created by chinalife on 2018/5/2.
 */
public class Problem7 {

    public int Fibonacci(int n) {
        if(n == 0 )
            return 0;
        if(n== 1)
            return 1;
          return Fibonacci(n-1)+Fibonacci(n-2);

    }

    public static void main(String[] args) {
        System.out.println(new Problem7().Fibonacci(30));
    }
}
