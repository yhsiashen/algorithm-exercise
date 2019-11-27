package org.yuhang.algorithm.leetcode.math;


/**
 * 数字的各个位相加 LC258
 */
public class ProblemAdddigits {

    public int addDigits(int num) {
        while (num/10!=0){
           int res = 0;
           while (num!=0){
               res += num%10;
               num /= 10;
           }
           num = res;
        }

        return num;
    }

    public static void main(String[] args) {

    }
}
