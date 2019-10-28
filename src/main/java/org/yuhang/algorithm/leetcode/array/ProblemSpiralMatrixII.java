package org.yuhang.algorithm.leetcode.array;


/**
 * 生成螺旋矩阵 LC59
 */
public class ProblemSpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if(n <= 0) return new int[][]{};
        int[][] res = new int[n][n];
        boolean[][] visited = new boolean[n][n]; //表示该位置被访问过
        int r = 0,c = 0; //起始位置
        int[] dr = {0,1,0,-1}; //行的方向:0表不变，1表增加一行，-1表减少一行
        int[] dc = {1,0,-1,0}; //列的方向
        int di = 0; //方向数组的索引
        for (int i = 1; i <= n*n ; i++) {
            res[r][c] = i;
            visited[r][c] = true;
            int cr = r +dr[di]; //预设下一个点
            int cc = c +dc[di];
            if( cr >=0 && cr<n && cc >=0 && cc<n && !visited[cr][cc]){ //看下一个点是否在范围内，且没被访问过
                r = cr; //确定下一个赋值的坐标
                c = cc;
            }else { //说明要转向,方向索引取下一个值,若到头了则取0
                if(di+1==4){
                    di = 0;
                }else {
                    di += 1;
                }
                r = r + dr[di]; //转向并确定下一个赋值的坐标
                c = c + dc[di];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ProblemSpiralMatrixII().generateMatrix(4);
    }
}
