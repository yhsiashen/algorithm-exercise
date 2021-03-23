package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.List;

/**
 * 8皇后问题
 */
public class EightQueensLcci {

    public List<List<String>> solveNQueens(int n) {
       List<List<String>> res = new ArrayList<>();
       if(n <= 0) return res;
       boolean[][] visited = new boolean[n][n];
       backtrace(res,new ArrayList<>(),visited,n, 0);
       return res;
    }


    private void backtrace(List<List<String>> res, List<String> list, boolean[][] visited, int n, int row){
        if(list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(row >= n){
            return;//超过n行了，直接返回
        }

        //遍历第row列的棋盘，依次判断哪个点可以摆放皇后
        for (int i = 0; i< n; i++) {
           if(judgeCanfill(visited,row,i,n)){//判断[row,i]点是否能摆放，判断其行、列、对角线是否有皇后
                visited[row][i] = true;
                list.add(constructStr(i,n));
                backtrace(res,list,visited,n,row+1);
                visited[row][i] = false;
                list.remove(list.size()-1);
           }
        }

    }

    private String constructStr(int i,int n) {
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if(j == i){
                str.append("Q");
            }else{
                str.append(".");
            }
        }
        return str.toString();

    }

    private boolean judgeCanfill(boolean[][] visited, int row, int i,int n) {
        for (int j = 0; j < row; j++) {//0~row-1行的i列若摆放了皇后，则直接返回
            if(visited[j][i]) return false;
        }
        for (int j = row,k=i; j >=0 && k>=0 ; j--,k--) {//判断左上对角线是否摆放了皇后
            if(visited[j][k]) return false;
        }
        for (int j = row,k=i; j >=0 && k<n ; j--,k++) {//判断右上对角线是否摆放了皇后
            if(visited[j][k]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new EightQueensLcci().solveNQueens(4));
    }
}
