package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.HashMap;

public class LastIndexOfNumber {


    public int[] getLastIndexOfNumber(int[] nums){
        ArrayList<Integer> list=  new ArrayList<>();
        if(nums.length == 0) return  new int[]{};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
             map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == i){
                list.add(nums[i]);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,10,10,9,9,9,8,7,10,9};
        int[] res = new LastIndexOfNumber().getLastIndexOfNumber(nums);
        for(int i:res){
            System.out.println(i);
        }
    }
}
