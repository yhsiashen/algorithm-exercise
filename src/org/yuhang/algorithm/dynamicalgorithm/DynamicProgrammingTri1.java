package org.yuhang.algorithm.dynamicalgorithm;

/**
 * 动态规划，三角形问题递归版
 */
public class DynamicProgrammingTri1 {

    private static int n =7;

    private static int[][] DMAX = {{3},{2,6},{4,3,5},{6,2,1,8},{0,2,1,5,4},{9,1,2,9,0,4},{9,1,2,9,0,4,8}};

    private static int MaxSum(int i,int j){
       if(i == n-1)
           return DMAX[i][j];
       int x = MaxSum(i+1,j);
       int y = MaxSum(i+1,j+1);
       return DMAX[i][j]+Math.max(x,y);
    }

    public static void main(String[] args) {
        System.out.println(MaxSum(0,0));
    }
}
