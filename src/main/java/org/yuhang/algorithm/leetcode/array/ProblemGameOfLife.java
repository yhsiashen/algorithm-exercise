package org.yuhang.algorithm.leetcode.array;

/**
 * 生命游戏 LC289
 */
public class ProblemGameOfLife {

    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int aroundLifeNum = 0;//细胞周围活细胞的数量
                if(i-1>=0 && (board[i-1][j] == 1 || board[i-1][j] == 2)) aroundLifeNum++;
                if(i+1<board.length && (board[i+1][j] == 1 || board[i+1][j] ==2)) aroundLifeNum++;
                if(j-1>=0 && (board[i][j-1] == 1 || board[i][j-1] == 2)) aroundLifeNum++;
                if(j+1<board[0].length && (board[i][j+1] == 1 || board[i][j+1] == 2)) aroundLifeNum++;
                if(i-1>=0 && j-1>=0 && (board[i-1][j-1] == 1 || board[i-1][j-1] == 2)) aroundLifeNum++;
                if(i-1>=0 && j+1 < board[0].length && (board[i-1][j+1] == 1 || board[i-1][j+1] == 2)) aroundLifeNum++;
                if(i+1 < board.length && j-1>=0 && (board[i+1][j-1] == 1 || board[i+1][j-1] == 2)) aroundLifeNum++;
                if(i+1 < board.length && j+1 < board[0].length && (board[i+1][j+1] == 1 || board[i+1][j+1] == 2)) aroundLifeNum++;

                if(board[i][j] == 1){//本细胞存活
                    if(aroundLifeNum<2 || aroundLifeNum > 3) board[i][j] = 2;
                }else {//本细胞死亡
                    if (aroundLifeNum == 3) board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 2)
                    board[i][j] = 0;
                else if(board[i][j] == 3)
                    board[i][j] = 1;
            }
        }

    }



    public void gameOfLife1(int[][] board) {

        int[] DX = {0,0,1,-1,1,1,-1,-1};//x轴的方向
        int[] DY = {1,-1,0,0,1,-1,1,-1};//y轴的方向

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int aroundLifeNum = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i+DX[k];
                    int y = i+DY[k];
                    if(x<0 || y<0|| x>=board.length || y>=board[0].length) continue;
                    aroundLifeNum+=board[x][y] & 1;
                }
                if(board[i][j] == 1){//本细胞存活
                    if(aroundLifeNum<2 || aroundLifeNum > 3) board[i][j] = 3;
                }else {//本细胞死亡
                    if (aroundLifeNum == 3) board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 3)
                    board[i][j] = 0;
                else if(board[i][j] == 2)
                    board[i][j] = 1;
            }
        }


    }


    public static void main(String[] args) {
        int[][] board = {{0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}};
        new ProblemGameOfLife().gameOfLife(board);
    }
}
