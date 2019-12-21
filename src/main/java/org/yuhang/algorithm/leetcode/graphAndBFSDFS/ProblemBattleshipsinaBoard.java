package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

/**
 * 计算甲板上的战舰 LC419
 * @tag:DFS
 */
public class ProblemBattleshipsinaBoard {

    int res;

    public int countBattleships(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(board[i][j] == 'X' && !visited[i][j]){
                   dfs(board,i,j,visited);
                   res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
        if(board[i][j] == '.')return;
        if(!visited[i][j]){
            visited[i][j] = true;
            dfs(board,i+1,j,visited);//向下找X值
            dfs(board,i-1,j,visited);//向上找X值
            dfs(board,i,j+1,visited);//向右找X值
            dfs(board,i,j-1,visited);//向左找X值
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        new ProblemBattleshipsinaBoard().countBattleships(board);
    }
}
