package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 完全平方数 279
 */
public class ProblemPerfectSquares {

    public int numSquares(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] num = new int[n+1]; //数组代表组成和为n的完全平方数的最小个数
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i < n+1; i++) {
           int closedPSN = (int)Math.sqrt(i);//最接近的完全平方数
           int minNum =  num[i-(int)Math.pow(closedPSN,2)]+1;
           while (closedPSN >1){ //从最接近的完全平方数开始遍历，一直到遍历到1，找出这期间最小的组合数
               num[i] = num[i-(int)Math.pow(closedPSN,2)]+1;
               if(num[i] < minNum) minNum = num[i];
               closedPSN--;
           }
           num[i] = minNum;
        }

        return num[n];
    }

    public static void main(String[] args) {
        System.out.println(new ProblemPerfectSquares().numSquares(12));
    }
}
