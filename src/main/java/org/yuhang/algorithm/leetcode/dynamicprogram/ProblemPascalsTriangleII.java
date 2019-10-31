package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角II LC119
 */
public class ProblemPascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return cur;
    }


    public static void main(String[] args) {
        new ProblemPascalsTriangleII().getRow(3);
    }
}
