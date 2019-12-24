package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 目标和 LC494
 * @tag:动态规划
 */
public class ProblemTargetsum {

    /**
     * 深搜
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        return find(nums,0,S);
    }

    private int find(int[] nums, int i, int s) {
        if(i == nums.length){
            return s==0?1:0;
        }
        return find(nums,i+1,s-nums[i])+find(nums,i+1,s+nums[i]);
    }

    /**
     * 二维动态规划
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays1(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];//dp[i][j]表示0~i区间的数组和为j的次数,根据题目限制条件,和的范围为-1000~1000，故最长长度为2001
        dp[0][nums[0]+1000]++;//选1*nums[0]
        dp[0][-nums[0]+1000]++;//选-1*nums[0]

        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000 ; j++) {
                if (j + nums[i] + 1000 >= 0 && j + nums[i] + 1000 < 2001)
                    dp[i][j + 1000] += dp[i - 1][j + nums[i] + 1000];
                if (j - nums[i] + 1000 >= 0 && j - nums[i] + 1000 < 2001)
                    dp[i][j + 1000] += dp[i - 1][j - nums[i] + 1000];
            }

        }
        return S>1000?0:dp[nums.length-1][S+1000];
    }

    /**
     * 一维动态规划
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays2(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0]+1000]++;
        dp[-nums[0]+1000]++;
        for (int i = 1; i <nums.length ; i++) {
            int[] tmp = new int[2001]; //申请临时数据暂存的dp状态
            for (int j = 1000; j >=-1000 ; j--) {
                if (j + nums[i] + 1000 >= 0 && j + nums[i] + 1000 < 2001)
                    tmp[j+1000] += dp[j+nums[i]+1000];
                if (j - nums[i] + 1000 >= 0 && j - nums[i] + 1000 < 2001)
                    tmp[j+1000] += dp[j-nums[i]+1000];
            }
            dp = tmp;
        }
        return S>1000?0:dp[S+1000];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(new ProblemTargetsum().findTargetSumWays2(nums,3));

    }
}
