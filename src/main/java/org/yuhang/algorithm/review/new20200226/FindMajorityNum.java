package org.yuhang.algorithm.review.new20200226;

import java.util.Arrays;

public class FindMajorityNum {

    public int majorityElement(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        int len = nums.length;//
        for (int i = 0; i < len-1;i++) {
             int cnt=0;
             while (i < len-1 && nums[i] == nums[i+1]){
                 cnt++;
                 i++;
                 if(cnt >= (len>>1)){
                     return nums[i];
                 }
             }
        }
        return -1;
    }

    /**
     * 投票法
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int taotal = 1;
        int people= nums[0];
        for(int i = 1;i<nums.length;i++){
            if(people!=nums[i]){
                taotal--;
            }else{
                taotal++;
            }
            if(taotal<0){
                people = nums[i];
                taotal = 1;
            }
        }
        return taotal>0?people:-1;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,2,5,9,9,5,5,5};
        System.out.println(new FindMajorityNum().majorityElement1(nums));
    }
}
