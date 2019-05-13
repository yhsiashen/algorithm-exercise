package org.yuhang.algorithm.leetcode.graph;

/**
 * 被围绕的区域  130
 */
public class ProblemSurroundedRegions {

    int row;
    int column;

    public void solve(char[][] board) {
       if(board.length == 0) return;
       row = board.length; //行
       column = board[0].length; //列
       //遍历边界找到所有与边界的O相连的O
        for (int i = 0; i < row ; i++) {
            DFS(board,i,0); //遍历第一列
            DFS(board,i,column-1); //遍历最后一列
        }

        for (int i = 0; i < column; i++) {
            DFS(board,0,i); //遍历第一行
            DFS(board,row-1,i); //遍历最后一行
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '$') board[i][j] = 'O';
            }
        }
    }

    private void DFS(char[][] board, int i, int j) {
        if(i<0 || i>row-1 || j<0 || j>column-1) return;//超出边界直接返回
        if(board[i][j]!='O') return; //如果不是'O'直接返回
        board[i][j] = '$';
        DFS(board,i-1,j);
        DFS(board,i+1,j);
        DFS(board,i,j-1);
        DFS(board,i,j+1);
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};

        new ProblemSurroundedRegions().solve(board);
//        System.out.println(false);
    }
}
