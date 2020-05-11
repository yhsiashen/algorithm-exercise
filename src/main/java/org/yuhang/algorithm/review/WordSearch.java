package org.yuhang.algorithm.review;

/**
 * 单词搜索 LC79
 */
public class WordSearch {

    private int m;
    private int n;
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board,i,j,word,visited))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, boolean[][] visited) {
        if(i < 0 || i>=m || j < 0 ||j >= n || visited[i][j] || board[i][j] != word.charAt(0)) return false;
        if(word.length() == 1 && board[i][j]== word.charAt(0))return true;

        visited[i][j] = true;
        for(int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(dfs(board,x,y,word.substring(1),visited)) return true;//有一个方向搜索到则返回存在
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a'}};
        System.out.println(new WordSearch().exist(board,"a"));
    }
}
