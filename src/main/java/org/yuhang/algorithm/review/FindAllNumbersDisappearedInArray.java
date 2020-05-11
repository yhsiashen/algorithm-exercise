package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到数组中消失的数字 LC448
 */
public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i+1 && nums[i]!= nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1){
                res.add(i+1);
            }
        }

        return res;
    }

    private void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
