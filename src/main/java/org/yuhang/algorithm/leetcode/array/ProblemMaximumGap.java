package org.yuhang.algorithm.leetcode.array;


import java.util.Arrays;

/**
 * 找数组的最大间距 LC164  时间复杂度和空间复杂度为O(n)
 */
public class ProblemMaximumGap {


    /**
     * 桶排序,当选用的桶数目较多时，时间复杂度趋近与O(n)
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int k = nums.length/2; //桶的数目
        for (int i = 0; i < nums.length-1;) {
            Arrays.sort(nums,i,i+k);
            i = i+k+1;
        }

        for (int i = 0; i < nums.length-1; i++) {

        }



        return 0;
    }

    private void sort(int[] nums,int a,int b){
        Arrays.sort(nums,a,b);
    }
}
