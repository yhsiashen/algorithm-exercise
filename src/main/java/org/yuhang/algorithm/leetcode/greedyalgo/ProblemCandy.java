package org.yuhang.algorithm.leetcode.greedyalgo;


import java.util.Arrays;

/**
 * 分发糖果 LC135
 *
 */
public class ProblemCandy {

    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        int[] left = new int[ratings.length];
        int[] rigth = new int[ratings.length];
        int res = 0;
        Arrays.fill(left,1);
        Arrays.fill(rigth,1);
        for (int i = 1; i < ratings.length ; i++) {
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }
        }

        for (int i = ratings.length-2; i >=0 ; i--) {
            if(ratings[i] > ratings[i+1]){
                rigth[i] = rigth[i+1]+1;
            }
        }

        for (int i = 0; i <ratings.length ; i++) {
            res += Math.max(left[i],rigth[i]);
        }

        return res;
    }
}
