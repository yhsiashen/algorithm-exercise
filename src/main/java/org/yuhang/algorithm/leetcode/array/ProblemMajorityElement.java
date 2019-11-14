package org.yuhang.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 求数组中的众数 LC169
 */
public class ProblemMajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for (Integer key:map.keySet()){
            if(map.get(key) > nums.length/2){
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(new ProblemMajorityElement().majorityElement(nums));
    }
}
