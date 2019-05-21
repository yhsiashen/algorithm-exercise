package org.yuhang.algorithm.leetcode.graphBFSDFS;



/**
 * 判断是否为有效的数独 36
 */
public class ProblemValidSudoku {

    public boolean isValidSudoku(char[][] board) {
      if(board == null || board.length == 0)
          return false;
      int row = board.length;
      int colunm = board[0].length;
      //记录某行某位数字是否被摆放,[i][num]表示第i行,num已被摆放
      boolean[][] rowMap = new boolean[9][10];
      boolean[][] columnMap = new boolean[9][10];
      boolean[][] cellMap = new boolean[9][10];
      //从(0,0)开始遍历，每次判断该点所处的行，列和子矩阵是否有重复的数字，有则直接返回false，否则遍历到结束
      for (int i = 0; i < row; i++) {
          for (int j = 0; j < colunm; j++) {
                if(board[i][j] >= '1' && board[i][j]<= '9'){
                    //字符转化为数字,减去'0'的ascii码值即可
                    int num = board[i][j] - '0';
                    //若所在行,列,子矩阵出现一个重复的数字，则直接返回false
                    if(rowMap[i][num] || columnMap[j][num] || cellMap[i/3*3+j/3][num]) return false;
                    rowMap[i][num] = true;
                    columnMap[j][num] = true;
                    cellMap[i/3*3+j/3][num] = true;
                }
            }
        }


      return true;
    }

}
