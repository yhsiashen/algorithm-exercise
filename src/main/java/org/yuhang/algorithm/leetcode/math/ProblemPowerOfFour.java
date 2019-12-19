package org.yuhang.algorithm.leetcode.math;


/**
 * 4的幂 LC342
 */
public class ProblemPowerOfFour {

    public boolean isPowerOfFour(int num) {
        if(num<=0) return false;
        while (num % 4==0){
            num /=4;
        }
        return num==1;
    }

    public boolean isPowerOfFour1(int num) {
        if(num < 0 || (num & (num-1))!=0){
            return false;
        }
        return (num & 0x55555555 )!=0;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemPowerOfFour().isPowerOfFour(255));
    }
}
