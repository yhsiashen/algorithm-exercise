package org.yuhang.algorithm.review.new20200226;

/**
 * 最长重复子数组
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1]
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class MaximumLengthOfRepeatedArray {


    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];//dp[i][j]表示nums1[0..i]和nums2[0...j]的最长公共子数组长度,公共子数组必须分别以i和j结尾
        int max = 0;
        //dp[i][j] = Math.max(dp[i-1][j-1]+ nums[i] == nums[j]?1:0, dp[i-1][j], dp[i][j-1])
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
               if(nums1[i-1] == nums2[j-1]){
                   dp[i][j] = dp[i-1][j-1]+1;
                   max = Math.max(max, dp[i][j]);
               }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        System.out.println(new MaximumLengthOfRepeatedArray().findLength(nums1,nums2));

    }
}
