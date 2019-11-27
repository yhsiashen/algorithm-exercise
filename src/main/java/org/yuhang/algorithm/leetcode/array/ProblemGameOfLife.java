package org.yuhang.algorithm.leetcode.array;


/**
 * 生命游戏 LC289
 */
public class ProblemGameOfLife {

    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0)return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0){ //判断死细胞能不能复活
                    if(checkStatus(board,i,j,true))
                        board[i][j] = 2; //2代表原先状态是0
                }else{
                    if(checkStatus(board,i,j,false))
                        board[i][j] = 3; //3代表原先状态是1
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <  board[0].length; j++) {
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private boolean checkStatus(int[][] board, int i, int j, boolean flag) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        if(i>0 && (board[i-1][j]==1 || board[i-1][j]==3) && board[i-1][j]!=2) count++;
        if(i>0 && j>0 && (board[i-1][j-1]==1 || board[i-1][j-1]==3) && board[i-1][j-1]!=2) count++;
        if(j>0 && (board[i][j-1]==1 || board[i][j-1]==3) && board[i][j-1]!=2) count++;
        if(i<m-1 && j>0 && (board[i+1][j-1]==1 || board[i+1][j-1]==3) && board[i+1][j-1]!=2) count++;
        if(i<m-1 && (board[i+1][j]==1  || board[i+1][j]==3) && board[i+1][j]!=2) count++;
        if(i<m-1 && j<n-1 && (board[i+1][j+1]==1||board[i+1][j+1]==3) && board[i+1][j+1]!=2) count++;
        if(j<n-1 && (board[i][j+1]==1 || board[i][j+1]==3) && board[i][j+1]!=2) count++;
        if(i>0 && j<n-1 && (board[i-1][j+1]==1 || board[i-1][j+1]==3) && board[i-1][j+1]!=2) count++;
        if(flag) {
            return count==3;
        }else{
            return count < 2 || count > 3;
        }

    }


    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        new ProblemGameOfLife().gameOfLife(board);
    }
}
