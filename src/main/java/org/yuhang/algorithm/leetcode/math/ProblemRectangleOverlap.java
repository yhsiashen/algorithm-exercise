package org.yuhang.algorithm.leetcode.math;

/**
 * 判断矩形是否重叠 LC836
 */
public class ProblemRectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
         return !(rec1[0] >= rec2[2] ||
                  rec1[2] <= rec2[0] ||
                  rec1[1] >= rec2[3] ||
                  rec1[3] <= rec2[1]); //算不重叠区域的所有情况，然后取反
    }
}
