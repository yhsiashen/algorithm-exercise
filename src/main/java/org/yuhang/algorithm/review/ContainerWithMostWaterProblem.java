package org.yuhang.algorithm.review;

/**
 * 盛最多水的容器 LC11
 */
public class ContainerWithMostWaterProblem {

    public int maxArea(int[] height) {
       int res = 0;
       int left = 0, right = height.length-1;
       while (left < right){
           int h = Math.min(height[left], height[right]);
           res = Math.max(res, h*(right-left));
           if(height[left] < height[right]){
               left++;
           }else{
               right--;
           }
       }

       return res;
    }
}
