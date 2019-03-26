package org.yuhang.algorithm.leetcode.dynamicprogram;

/**  动态规划-不同路径问题-记忆性递归
 * Created by chinalife on 2018/6/9.
 */
public class ProblemUniquePaths {

    //表示m*n的格子有多少条路径
    private int[][] routin = new int[101][101];

    public int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            routin[m][n]=1;
        if(routin[m][n]!=0)
            return routin[m][n];
        routin[m][n] =  uniquePaths(m-1,n)+uniquePaths(m,n-1);
        return routin[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new ProblemUniquePaths().uniquePaths(7,3));

    }
}
