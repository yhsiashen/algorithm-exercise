package org.yuhang.algorithm.leetcode.dynamicprogram;

public class NumArray {
        int[] numbers;
        int[] dp;

        public NumArray(int[] nums) {
           if(nums.length > 0){
               this.numbers = nums;
               dp = new int[nums.length];
               dp[0] = nums[0];
               for (int i = 1; i < nums.length; i++) {
                   dp[i] = dp[i-1]+nums[i];
               }
           }
        }

        public void update(int i, int val) {
            int diff = val - numbers[i];
            numbers[i] = val;
            for (int j = i; j < numbers.length ; j++) {//更改dp数组
                dp[j]+=diff;
            }
        }

        public int sumRange(int i, int j) {
            return i>0?dp[j]-dp[i-1]:dp[j];
        }

       public static void main(String[] args) {
          int[] nums = {7,2,7,2,7,0};
          NumArray numArray = new NumArray(nums);
          numArray.update(4,6);
          numArray.update(0,2);
          numArray.update(0,9);
          System.out.println(numArray.sumRange(4,4));
          numArray.update(3,8);
          System.out.println(numArray.sumRange(0,4));
       }

}
