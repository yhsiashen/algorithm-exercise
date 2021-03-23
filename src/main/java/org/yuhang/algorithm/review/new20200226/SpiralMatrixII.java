package org.yuhang.algorithm.review.new20200226;

/**
 * 螺旋矩阵II
 */
public class SpiralMatrixII {


    public int[][] generateMatrix(int n) {
        if(n == 1) return new int[][]{{1}};
        int[][] res = new int[n][n];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};//方向,分别表示右、下、左、上
        int dirs = 0;
        int i=0,j=0;
        int cnt = 1;
        while (cnt <= n*n){
            res[i][j] = cnt;
            //判断下一个点是否越界或已被占用
            int nexti = i + dir[dirs][0];
            int nextj = j + dir[dirs][1];
            if(nexti >=0 && nexti < n && nextj >=0 && nextj < n && res[nexti][nextj] == 0){
                i = nexti;
                j = nextj;
            }else {//转方向
                dirs = (dirs+1)%4 ;
                i += dir[dirs][0];
                j += dir[dirs][1];
            }
            cnt++;
        }
        return res;
    }

    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(3);
    }

}
