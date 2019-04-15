package org.yuhang.algorithm.leetcode.array;


/**
 * O(1)空间复杂度移除数组中等于指定元素的元素  27
 */
public class ProblemRemoveElement {

    /**
     * 双指针法，和val不相等的就用i指向
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
         if(nums == null || nums.length ==0)
             return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(new ProblemRemoveElement().removeElement(nums,2));
    }
}
