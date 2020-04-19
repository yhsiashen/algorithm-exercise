package org.yuhang.algorithm.review;

/**
 * 找到最小的缺失整数 LC41
 */
public class FindMinimunMissingNumProblem {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if(nums.length == 0) return 1;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i]-1]!=nums[i]){
                int tmp = nums[nums[i]-1];//交换索引nums[i]-1与i的位置
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < len ; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return len+1;
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimunMissingNumProblem().firstMissingPositive(new int[]{3,4,-1,1}));
    }
}
