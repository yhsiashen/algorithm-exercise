package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成杨辉三角 LC118
 */
public class ProblemPascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> res = new ArrayList<>();
      if(numRows == 0) return res;
      List<Integer> one = new ArrayList<>();
      one.add(1);
      res.add(one);
      int i = 1;
      while (i < numRows){
          List<Integer> list = new ArrayList<>();
          for (int j = 0; j <= i; j++) {
             if(j == 0 || j==i) {
                 list.add(1);
             }else {
                 list.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
             }
          }
          i++;
          res.add(list);
      }
      return res;
    }

    public static void main(String[] args) {
        new ProblemPascalsTriangle().generate(5);
    }

}
