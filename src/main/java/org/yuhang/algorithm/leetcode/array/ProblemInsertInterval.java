package org.yuhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 插入区间 LC57
 */
public class ProblemInsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
       if(intervals.length == 0) return new int[][]{newInterval};
       if(newInterval.length == 0) return intervals;
//       int[][] newIntervals = new int[intervals.length+1][2];
        List<int[]> res = new ArrayList<>();
        int intervalsLength = intervals.length;
        int[][] newIntervals =  Arrays.copyOf(intervals,intervalsLength+1); //搬移到新数组
        newIntervals[intervalsLength] = newInterval;
        Arrays.sort(newIntervals, Comparator.comparingInt(o -> o[0])); //按升序排列
        int count = 0;
        while (count < newIntervals.length){
            int left = newIntervals[count][0];
            int right = newIntervals[count][1];
            while ( count < newIntervals.length-1 && right >= newIntervals[count+1][0]){
                right = Math.max(right,newIntervals[count+1][1]);
                count++;
            }
            res.add(new int[]{left,right});
            count++;

        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        new ProblemInsertInterval().insert(intervals,newInterval);
    }
}
