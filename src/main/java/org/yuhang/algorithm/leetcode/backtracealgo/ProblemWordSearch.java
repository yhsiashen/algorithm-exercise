package org.yuhang.algorithm.leetcode.backtracealgo;


/**
 * 单词搜索 LC79
 * @tag:回溯算法
 */
public class ProblemWordSearch {

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || "".equals(word)) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0) &&
                    dfs(board,word,visited,i,j))
                    return true;
                }
            }
        return false;
    }

    private boolean dfs(char[][] board,String word,boolean[][] visited,int i,int j){
        if("".equals(word)) {
            return true; //遍历到word结束，返回成功
        }
        if(i>=board.length || i<0 || j<0 ||j>=board[0].length || visited[i][j]
               || board[i][j] !=word.charAt(0)) return false; //越界或不等于首字符或之前被访问过,返回失败

        visited[i][j] = true; //标识已被访问
        if( dfs(board, word.substring(1), visited, i + 1, j) //有一个方向能被访问则返回true
            || dfs(board, word.substring(1), visited, i - 1, j)
            || dfs(board, word.substring(1), visited, i, j + 1)
            || dfs(board, word.substring(1), visited, i, j - 1))
            return true;
        visited[i][j] = false;//回溯，将该位置标记为未被访问
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        System.out.println(new ProblemWordSearch().exist(board,"SEE"));

    }
}
