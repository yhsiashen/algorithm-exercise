package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 不同路径 62
 * Created by chinalife on 2018/6/9.
 */
public class ProblemUniquePaths {

    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
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
                routin[i][j] = routin[i-1][j]+routin[i][j-1]; //i*j网格共有多少种不同走法
            }
        }
        return routin[m][n];
    }

    //表示m*n的格子有多少条路径
    private int[][] routin = new int[101][101];

    /**
     * 递归型动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        if(m==1 || n==1)
            routin[m][n]=1;
        if(routin[m][n]!=0)
            return routin[m][n];
        routin[m][n] =  uniquePaths1(m-1,n)+uniquePaths1(m,n-1);
        return routin[m][n];
    }

    /**
     * 递归、剪枝、缓存
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m,int n){
        int[][] res = new int[m][n];
        return rec(0,0,m,n,res);
    }

    private int rec(int i, int j, int m, int n,int[][] res) {
        if(i > m-1 || j > n-1) return 0; //超过网格边界，剪枝
        if(i == m-1 || j == n-1) return 1;
        if(res[i][j] > 0) return res[i][j]; //缓存
        res[i][j] = rec(i+1,j,m,n,res)+rec(i,j+1,m,n,res);
        return res[i][j];

    }


    public static void main(String[] args) {
        System.out.println(new ProblemUniquePaths().uniquePaths(7,3));

    }
}
