package org.yuhang.algorithm.leetcode.dynamicprogram;


/**
 * 分割等和子集 LC416
 * @tag:动态规划 
 */
public class ProblemPartitionequalSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num:nums) sum+=num;
        if((sum & 1) == 1) return false;//和为奇数，不可能分割成等和子集
        int target =   sum >> 1; //目标和为sum的一半，转换为0-1背包问题
        boolean[][] dp = new boolean[nums.length][target+1]; // dp[i][j]表示0~i内选取若干数的和能否等于j
        for (int i = 0; i < target+1; i++) {
            if(nums[0] == i){
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < target+1; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[nums.length-1][target];
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num:nums) sum+=num;
        if((sum & 1) == 1) return false;//和为奇数，不可能分割成等和子集
        int target = sum >> 1; //目标和为sum的一半，转换为0-1背包问题
        boolean[] dp = new boolean[target+1];
        for (int i = 0; i < target+1; i++) {
            if(nums[0] == i){
                dp[i] = true;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >=0 && j>=nums[i]; j--) { //target从高位开始遍历目的是防止低位先变了影响高位的结果
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
        
    }

    public static void main(String[] args) {
        System.out.println(new ProblemPartitionequalSubsetSum().canPartition1(new int[]{1,2,3,4,5,6,7}));
    }
}
