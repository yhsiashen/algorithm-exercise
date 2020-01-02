package org.yuhang.algorithm.leetcode.array;

/**
 * 盛水最多的容器 LC11
 * @tag:双指针
 */
public class ProblemContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0,right = height.length-1;
        int res = 0;
        while (left < right) {
            int h = Math.min(height[left],height[right]);
            res = Math.max(res,h*(right-left));
            if(height[left] < height[right]) left++;
            else right--;

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
