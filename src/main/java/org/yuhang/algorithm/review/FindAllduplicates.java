package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有重复的元素 LC442
 */
public class FindAllduplicates {

    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> res = new ArrayList<>();
       int n = nums.length;
       for (int i = 0; i < n; i++) {
           nums[(nums[i]-1) % n] += n;
       }
       for (int i = 0; i < n; i++) {
            if(nums[i] > 2*n) res.add(i+1);
       }
       return res;
    }
}
