package org.yuhang.algorithm.review;

/**
 * 最长上升子序列 LC300
 */
public class LongestIncreasingSubseq {

    /**
     * 普通的动态规划,O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];//dp[i]表示以nums[i]结尾的最长上升子序列
        int res = 0;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1];
            for (int j = i-1; j >=0 ; j--) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * 贪心思想+动态规划,O(nlogn)
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];//d[i]表示所有长度为i+1的递增子序列中，尾数最小的子序列
        for(int num:nums){
            int l = 0,r= max;
            while (l<r){
                int mid = (l+r)/2;
                if(dp[mid] < num){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }
            dp[l] = num;
            if(l == max){
                 max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new LongestIncreasingSubseq().lengthOfLIS1(nums));
    }

}
