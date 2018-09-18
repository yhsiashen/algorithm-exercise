package com.chinalife.springmvc.algorithm.rowtooffer;

/**二进制中1的个数
 * Created by chinalife on 2018/5/3.
 */
public class Problem11 {
    public int NumberOf1(int n) {
        int count = 0;
        for(int i =31;i>=0;i--){
            if((n>>>i & 1) == 1){
              count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Problem11().NumberOf1(-14));
    }
}
