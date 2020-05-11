package org.yuhang.algorithm.leetcode.array;

/**
 * 统计优美子数组的个数 LC1248
 * @tag:双指针
 */
public class ProblemNiceSubarrays {

    /**
     * 双指针
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums.length < k) return 0;
        int res = 0;
        int l = 0, r = 0;
        int count = 0;
        int preEven = 0;
        while (r < nums.length){
            if(count < k) {
                if ((nums[r] & 1) == 1) count++;
                r++;
            }

            if(count == k){
                preEven = 0;
                while (count == k){
                   res++;
                   if((nums[l]&1)==1)count--;
                   l++;
                   preEven++;
                }
            }else{
                res+=preEven;
            }
        }

        return res;
    }

    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays1(int[] nums, int k) {
//        for (int i = 0; i < nums.length; i++) {
//            if((nums[i] & 1) == 1){
//                nums[i] = 1;
//            }else{
//                nums[i] = 0;
//            }
//        }

        int res = 0;
        int preSum = 0;
        int[] map = new int[nums.length+1];
        map[0] =1;
        for (int i = 1; i < nums.length+1; i++) {
             preSum += nums[i-1] & 1;//nums的前缀和
             if(preSum>=k) res += map[preSum-k];
             map[preSum]++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,2};
        System.out.println(new ProblemNiceSubarrays().numberOfSubarrays1(nums,2));
    }
}
