package org.yuhang.algorithm.leetcode.greedyalgo;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间的最大数量  435
 */
public class ProblemEraseOverlapIntervals {


    /**
     * 区间定义
     */
    public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

    public int eraseOverlapIntervals(Interval[] intervals) {
         if(intervals==null || intervals.length==0)
             return 0;
         //先将区间根据右端点的大小排升序
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                    return o1.end-o2.end;
            }
        });
        int result = 1;
        Interval curResultInterval = intervals[0];
        //从排好序的数组第一个元素起，遍历数组，判断元素右端点是否在前面已选区域中
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i].start>=curResultInterval.end){
                curResultInterval.end = intervals[i].end;
                result++;
            }
        }

        return intervals.length-result;
    }


    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1,100);
        intervals[1] = new Interval(11,11);
        intervals[2] = new Interval(1,12);
        intervals[3] = new Interval(2,11);
        Arrays.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                return o2.end-o1.end;
            }
        });

        for (Interval in :intervals) {
            System.out.println(in.end+" "+in.start);
        }

//        System.out.println(new ProblemEraseOverlapIntervals().eraseOverlapIntervals(intervals));
    }

}
