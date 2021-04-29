package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *打乱数组
 *
 * 1 <= nums.length <= 200
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 10^4 次 reset 和 shuffle
 *
 */
public class ShuffleAnArray {

    int[] nums;
    int[] initailNums;
    Random random = new Random();

    public ShuffleAnArray(int[] nums){
        this.nums = nums;
        this.initailNums = nums.clone();
    }

    public int[] reset() {
        nums = initailNums;
        initailNums = initailNums.clone();
        return nums;
    }

    public int[] shuffle() {
        int len = nums.length;
        if(len == 1) return nums;
        List<Integer> copyList = getArraycopy();
        for (int i = 0; i < len; i++) {
            int randomIdx = random.nextInt(copyList.size());
            nums[i] = copyList.get(randomIdx);
            copyList.remove(randomIdx);
        }
        return nums;
    }

    private List<Integer> getArraycopy(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] tmp = nums;
        tmp[0] = -1;
        for(int i: nums){
            System.out.println(i);
        }
//        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(nums);
//        shuffleAnArray.reset();
    }
}
