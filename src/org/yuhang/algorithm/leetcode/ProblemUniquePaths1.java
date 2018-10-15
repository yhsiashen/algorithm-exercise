package org.yuhang.algorithm.leetcode;

/** 路径问题-递推型递归
 * Created by chinalife on 2018/6/24.
 */
public class ProblemUniquePaths1 {
    public int uniquePaths(int m, int n) {
        int[][] routin = new int[m+1][n+1];
        for(int i = 1;i<=m;i++){
            routin[i][1] = 1;
        }
        for(int i = 1;i<=n;i++){
            routin[1][i] = 1;
        }
        for(int i = 2;i<=m;i++){
            for(int j = 2;j<=n;j++){
                routin[i] [j] = routin[i-1][j]+routin[i][j-1];
            }
        }
        return routin[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new ProblemUniquePaths1().uniquePaths(7,3));
    }

}
