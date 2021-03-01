package org.yuhang.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 零矩阵 面试题1.08
 */
public class ProblemZeroMatrixLcci {

    private class Pair{
        int x;
        int y;

        public Pair(int x,int  y){
            this.x = x;
            this.y = y;
        }
    }

    public void setZeroes(int[][] matrix) {
       if(matrix.length == 0 || matrix[0].length == 0) return;
       int row = matrix.length;
       int col = matrix[0].length;
       List<Pair> zoreIndexes = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 0) {
                    zoreIndexes.add(new Pair(i,j));
                }
            }
        }

        for(Pair zoreIndex: zoreIndexes){
            for (int i = 0; i < row; i++) {
                matrix[i][zoreIndex.y] = 0;
            }
            for (int j = 0; j < col; j++) {
                matrix[zoreIndex.x][j] = 0;
            }
        }
    }
}
