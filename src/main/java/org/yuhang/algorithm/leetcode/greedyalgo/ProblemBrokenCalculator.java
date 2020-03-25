package org.yuhang.algorithm.leetcode.greedyalgo;

/**
 * 坏了的计算器 LC991
 */
public class ProblemBrokenCalculator {

    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y>X){
           if(Y%2==0){
               Y /= 2;
               res++;
           } else{
               Y = (Y+1)/2;
               res+=2;
           }
        }
        return res+X-Y;
    }
}
