package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 插入区间 LC57
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] merge = new int[len+1][2];
        System.arraycopy(intervals,0,merge,0,len);
        merge[len] = newInterval;
        Arrays.sort(merge, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < len+1){
            int left = merge[i][0];
            int right = merge[i][1];
            while (i < len && right >= merge[i+1][0]){
                right = Math.max(right, merge[++i][1]);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        new InsertInterval().insert(intervals,newInterval);
    }
}
