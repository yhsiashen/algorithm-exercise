package org.yuhang.algorithm.leetcode.backtracealgo;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题  51
 */
public class ProblemNQueens {

    List<List<String>> allSolves = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if(n <= 0)
            return allSolves;
        //长度为n的数组下标表示行，值表示列的位置，两者确定棋盘中一个皇后存放的位置
        int[] queen = new int[n];
        for (int i = 0; i < n; i++) {
            queen[i] = Integer.MAX_VALUE;
        }
        DFS(0,n,queen);
        return allSolves;
    }


    /**
     * 把放棋子的过程分为n个阶段，一行一行的放，放的时候不断的检查当前的状态，
     * 若不满足，则回溯到上一行继续找满足的放法
     * @param row
     * @param n
     */
    private void  DFS(int row,int n,int[] queen){
        //递归终止条件，此时表示一种可能性已出，将其放入结果List中
        if(row == n){
            putInResult(queen);
            return;
        }
        //考察每行的n个列，从第0列开始
        for (int column = 0; column < n ; column++) {
            if(isOk(row,column,queen)){ //满足条件，则将(row,column)放入queen中
                queen[row] = column;
                DFS(row+1,n,queen);//考察下一行
            }
        }
    }

    /**
     * 判断第row行的column列是否能放皇后,即判断该点所在的行,列,对角线及反对角线是否已有皇后
     * @param row
     * @param column
     * @return
     */
    private boolean isOk(int row, int column,int[] queen) {
        // (row-1,column-1)表示点(row,column)的左斜边最近的点
        int leftup = column-1;
        // (row-1,column+1)表示点(row,column)的左斜边最近的点
        int rightup = column+1;
        //逐行往上判断
        for (int i = row-1; i >=0 ; i--) {
            if(queen[i] == column) return false;//第i行的column列已经有皇后，直接返回错误
            if(leftup >=0 ) {
                if(queen[i] == leftup) return false; //第(i,column-1)的位置已有皇后，直接返回错误
            }
            if(rightup >=0){
                if(queen[i] == rightup) return false; //第(i,column+1)的位置已有皇后，直接返回错误
            }
            leftup--;
            rightup++;

        }

        //row行之前的行都判断完毕，则该点可以放皇后
        return true;


    }

    private void putInResult(int[] queen){
        List<String> everyResult = new ArrayList<>();
        StringBuilder rowStr = new StringBuilder();
        for (int i = 0; i < queen.length; i++) {
            for (int j = 0; j < queen.length; j++) {
                if(j == queen[i]){
                    rowStr.append('Q');
                }else {
                    rowStr.append('.');
                }
            }
            everyResult.add(rowStr.toString());
            rowStr = new StringBuilder();
        }

       allSolves.add(everyResult);
    }


    public static void main(String[] args) {
        System.out.println(new ProblemNQueens().solveNQueens(4));
    }
}
