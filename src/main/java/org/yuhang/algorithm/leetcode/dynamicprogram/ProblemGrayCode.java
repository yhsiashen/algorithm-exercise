package org.yuhang.algorithm.leetcode.dynamicprogram;


import java.util.ArrayList;
import java.util.List;

/**
 * 求数字的格雷编码 LC89
 */
public class ProblemGrayCode {

    public List<Integer> grayCode(int n) {
      List<Integer> res = new ArrayList<>();
      res.add(0);
      for (int i = 0; i < n; i++) {
         int add = 1 << i; //将之前的格雷码的高位加1，反序加入结果中即可
          for (int j = res.size()-1; j >=0 ; j--) {
               res.add(res.get(j) + add);
          }
      }
      return res;
    }

    public static void main(String[] args) {
        new ProblemGrayCode().grayCode(3);
    }
}
