package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};//方向,分别表示右、下、左、上
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];//代表此点是否被访问过
        int dirs = 0;//表示方向的指向,一开始为右
        int i=0,j=0;//表示起点
        while (res.size() < m*n){
            if(i >= 0 && i < m && j >=0 && j< n && !visited[i][j]){
                visited[i][j] = true;
                res.add(matrix[i][j]);
            }else {//遇到访问过的点或到达边界时需要改变方向
                if(dirs == 0){
                    j--;
                }else if(dirs == 1){
                    i--;
                }else if(dirs == 2){
                    j++;
                }else {
                    i++;
                }
                dirs = (dirs+1) % 4;
            }
            i += dir[dirs][0];//下个坐标
            j += dir[dirs][1];


        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        new SpiralMatrix().spiralOrder(matrix);
    }
}
