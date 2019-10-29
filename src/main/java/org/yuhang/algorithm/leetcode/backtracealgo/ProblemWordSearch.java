package org.yuhang.algorithm.leetcode.backtracealgo;


/**
 * 单词搜索 LC79
 * @tag:回溯算法
 */
public class ProblemWordSearch {

    private static boolean res = false;

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0 || "".equals(word)) return false;
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited ;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)){ //找首元素
                    visited = new boolean[row][col];
                    dfs(board,word,visited,i,j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] board,String word,boolean[][] visited,int i,int j){
        if("".equals(word)) {
            res = true;
            return;
        }
        if(i>=board.length || i<0 || j<0 ||j>=board[0].length) return; //越界或不等于首字符,直接返回

        if(!visited[i][j]) { //不允许重复使用
            visited[i][j] = true;
            dfs(board, word.substring(1), visited, i + 1, j);//向右
            dfs(board, word.substring(1), visited, i - 1, j);//向左
            dfs(board, word.substring(1), visited, i, j + 1);//向下
            dfs(board, word.substring(1), visited, i, j - 1);//向上
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a'}};
        System.out.println(new ProblemWordSearch().exist(board,"a"));

    }
}
