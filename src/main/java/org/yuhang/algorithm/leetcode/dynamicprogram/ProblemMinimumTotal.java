package org.yuhang.algorithm.leetcode.dynamicprogram;

import org.yuhang.algorithm.leetcode.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求三角形的最小路径和  120
 */
public class ProblemMinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
      if(triangle.size() == 0) return 0;
      int row = triangle.size();
      int[][] path = new int[row][row]; //path[i][j]表示点(i,j)到三角形底边的最小路径和,(0,0)则表示顶点到底边的最小路径和
        for (int i = 0; i < row; i++) {
            path[row-1][i] = triangle.get(row-1).get(i);//初始化最底层
        }
        for (int i = row-2; i >=0; i--) { //从倒数第二次开始开始往上，填充整个path数组
            List<Integer> curRow = triangle.get(i);
            for (int j = 0; j < curRow.size(); j++) {
                path[i][j] = Math.min(path[i+1][j],path[i+1][j+1])+curRow.get(j);
            }
        }
        return path[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        int[][] i = {{2},{3,4},{6,5,2},{4,1,8,1}};
        Arrays.asList();
    }

}
