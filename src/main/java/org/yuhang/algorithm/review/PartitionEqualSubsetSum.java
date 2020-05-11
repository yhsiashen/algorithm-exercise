package org.yuhang.algorithm.review;

/**
 * 分割等和子集 LC416
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if( nums.length == 1) return false;
        int sum = 0;
        for(int num:nums){
            sum += num;
        }

        if((sum & 1) == 1){//和为奇数
            return false;
        }

        int target = sum >> 1;//找目标值为sum的一半
        boolean[][] dp = new boolean[nums.length][target+1];//dp[i][j]表示nums[0~i]能否组成j
        if(nums[0]< target+1) dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < target+1; j++) {
                if(j-nums[i] >= 1){
                    dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length-1][target];
    }

    public boolean canPartition1(int[] nums) {
        if( nums.length == 1) return false;
        int sum = 0;
        for(int num:nums){
            sum += num;
        }

        if((sum & 1) == 1){//和为奇数
            return false;
        }

        int target = sum >> 1;//找目标值为sum的一半
        boolean[] dp = new boolean[target+1];//dp[j]表示nums能否组成j
        if(nums[0]< target+1) dp[nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = target+1; j >=0; j--) {
                if(j-nums[i] > 0) dp[j] = dp[j-nums[i]];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
//        int[] nums = {2};
//        int[] nums = {2,1};
//        int[] nums = {1,1,2};
//        int[] nums = {1,5,11,5};
        int[] nums = {2,2,3,5};
        System.out.println(new PartitionEqualSubsetSum().canPartition1(nums));
    }
}
