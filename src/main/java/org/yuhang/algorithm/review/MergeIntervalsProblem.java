package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间 LC56
 */
public class MergeIntervalsProblem {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));//按第一位从小到到大排序
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        while (i<intervals.length){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length-1 && right >= intervals[i+1][0]){//循环直到找到一个不重复区间
                right = Math.max(right, intervals[++i][1]);
            }
            res.add(new int[]{left,right});
            i++;
        }

        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        new MergeIntervalsProblem().merge(intervals);
    }
}
