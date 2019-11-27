package org.yuhang.algorithm.leetcode.math;


import java.util.HashMap;
import java.util.Map;

/**
 * Nim游戏 LC292
 */
public class ProblemNimGame {


    /**
     * 动态规划
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        if(n>=1 && n<=3) return true;
        boolean[] result = new boolean[n+1];
        result[1] = true;
        result[2] = true;
        result[3] = true;
        for (int i = 4; i <=n; i++) {
             result[i] = !result[i-1] || !result[i-2] || !result[i-3];
        }
        return result[n];
    }

    /**
     * 找规律推理
     * @param n
     * @return
     */
    public boolean canWinNim1(int n){
        return (n%4!=0);
    }


}
