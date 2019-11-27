package org.yuhang.algorithm.leetcode.math;


/**
 * 判断一个数是否是丑数 LC263
 *
 */
public class ProblemIsUgly {

    public boolean isUgly(int num) {
        if (num<1) return false;
        while (num%5==0){
            num/=5;
        }
        while (num%3==0){
            num/=3;
        }
        while (num%2==0){
            num>>=1;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemIsUgly().isUgly(6));
    }
}
