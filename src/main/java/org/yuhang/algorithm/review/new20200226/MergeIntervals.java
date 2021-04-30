package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));//将数组按左边界从小到大排序
        List<int[]> list = new ArrayList<>();
        int[] tmp = new int[2];
        tmp[0] = intervals[0][0];
        tmp[1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > tmp[1]){//intervals[i]与tmp数组不重合
               list.add(tmp);
               tmp = intervals[i];
            }else{
               tmp[1] = Math.max(tmp[1], intervals[i][1]);
            }
        }
        list.add(tmp);
        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = new MergeIntervals().merge(intervals);
        for(int[] n:res){
            System.out.println(n[0]+" "+n[1]);
        }
    }
}
