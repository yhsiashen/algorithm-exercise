package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 动态规划算法  求数组和的最大值
 * Created by yuhang on 2018/3/25.
 */
public class ProblemMaxSum {

    private static int getMaxSum(int[] a,int i){
        if(i<0){
            return 0;
        }
        if(a[i]<=0){
            return getMaxSum(a,i-1);
        }else {
            return (getMaxSum(a,i-1)+a[i]);
        }

    }

    public static void main(String[] args) {
        int[] a= {0,1,-2,1,3,4,6,-4,-6,7,8,-2,-3,2};
        System.out.println(getMaxSum(a,a.length-1));
    }
}
