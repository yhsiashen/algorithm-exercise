package org.yuhang.algorithm.dynamicalgorithm;

/** 动态规划-三角形问题记忆性递归版
 * Created by chinalife on 2018/6/22.
 */
public class DynamicProgrammingTri2 {
    private static int n =7;

    private static int DMAX[][] = {{3},{2,6},{4,3,5},{6,2,1,8},{0,2,1,5,4},{9,1,2,9,0,4},{9,1,2,9,0,4,8}};

    private static int maxSum[][] = {{-1},{-1,-1},{-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1,-1}};


    public static void main(String[] args) {
        System.arraycopy(DMAX[n - 1], 0, maxSum[n - 1], 0, n);
        for(int i = n-2 ; i>=0 ; i--){
            for(int j = 0;j<= i;j++){
                maxSum[i][j] = Math.max(maxSum[i+1][j],maxSum[i+1][j+1])+DMAX[i][j];
            }
        }
        System.out.println(maxSum[0][0]);
    }
}
