package org.yuhang.algorithm.leetcode.backtracealgo;


/**
 * 解数独 LC37
 */
public class ProblemSudokuSlover {


    public void solveSudoku(char[][] board) {
        if(board.length == 0 || board[0].length ==0) return;
        boolean[][] rowMap = new boolean[9][10];
        boolean[][] colMap = new boolean[9][10];
        boolean[][] cellMap = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int num = board[i][j] -'0';
                    rowMap[i][num] = true;
                    colMap[j][num] = true;
                    cellMap[i/3*3+j/3][num] = true;
                }
            }
        }

        backtrace(board,rowMap,colMap,cellMap,0,0);


    }

    private boolean backtrace(char[][] board, boolean[][] rowMap,boolean[][] colMap, boolean[][] cellMap,int i, int j) {

        while (board[i][j]!=0){//找空位
            if(++j>=9){
                i++;
                j=0;
            }
            if(i>=9){
                return true;//找不到空位了，则数独填写完毕
            }
        }

        for (int num = 1; num < 10; num++) {//可选的填充数字为1~9
            if(!rowMap[i][num] && !colMap[j][num] && !cellMap[i/3*3+j/3][num]){
                 board[i][j] = (char)('0'+ num);//填充num
                 rowMap[i][num] = true;
                 colMap[j][num] = true;
                 cellMap[i/3*3+j/3][num] = true;
                 if(backtrace(board,rowMap,colMap,cellMap,i,j)){
                     return true;
                 }else{
                     //回溯
                     board[i][j] = '.';//填充num
                     rowMap[i][num] = false;
                     colMap[j][num] = false;
                     cellMap[i/3*3+j/3][num] = false;
                 }
            }
        }

        return false;

    }


}
