package org.yuhang.algorithm.review.new20200226;

import java.util.List;
import java.util.Random;

public class ShuffleAnArray1 {

    int[] nums;
    int[] initailNums;
    Random random = new Random();

    public ShuffleAnArray1(int[] nums){
        this.nums = nums;
        this.initailNums = nums.clone();
    }

    public int[] reset() {
        nums = initailNums;
        initailNums = initailNums.clone();
        return nums;
    }

    /**
     * 洗牌法
     * @return
     */
    public int[] shuffle() {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int idx = getNextRandomIdx(i,len);
            swap(nums, i, idx);
        }
        return nums;
    }

    /**
     * 得到[i,j)范围内的一个随机整数
     * @param i
     * @param j
     * @return
     */
    private int getNextRandomIdx(int i,int j){
       return random.nextInt(j-i)+i;
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
