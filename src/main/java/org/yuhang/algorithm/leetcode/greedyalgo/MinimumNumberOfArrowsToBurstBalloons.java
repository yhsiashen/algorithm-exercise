package org.yuhang.algorithm.leetcode.greedyalgo;

import java.util.Arrays;

/**
 * 用最少数量的箭引爆气球 LC452
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        //将气球位置按xstart从小到大排序
        Arrays.sort(points, (o1,o2) -> Integer.compare(o1[1], o2[1]));
        int res=0;
        int i=0;
        while (i < points.length){
            int right = points[i][1];
            i++;
            while (i< points.length && points[i][0] <= right){
                i++;
            }
            res++;
        }
        return res;
    }

    public int findMinArrowShots1(int[][] points) {
        if(points.length == 0) return 0;
        //将气球位置按xstart从小到大排序
        Arrays.sort(points, (o1,o2) -> Integer.compare(o1[0], o2[0]));
        int res=0;
        int i=0;
        while (i < points.length){
            int right = points[i][1];
            i++;
            while (i< points.length && points[i][0] <= right){
                i++;
                right = Math.min(right, points[i][1]);
            }
            res++;

        }
        return res;
    }
}
