package org.yuhang.algorithm.leetcode.math;

/**
 * 水壶问题 LC365
 *
 */
public class ProblemWaterAndJugProblem {

    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(x == 0 || y == 0){
            return z==0 || x+y ==z;
        }
        //判断x和y的最大公约数能否被z整除
        return z % gcd(x,y) == 0;
    }

    private int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
