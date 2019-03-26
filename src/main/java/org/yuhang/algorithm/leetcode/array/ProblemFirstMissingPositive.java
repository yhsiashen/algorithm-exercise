package org.yuhang.algorithm.leetcode.array;

/**
 * 找出给定数组中没有出现的最小正整数，要求时间复杂度O(n),空间复杂度为O(1)  41
 */
public class ProblemFirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length==0)
            return 1;
        bucketSort(nums);
        //遍历排序好的数组，找到第一个不对应桶的元素即为缺失的数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }


    /**
     * 桶排序,将数字置于相应的桶中
     * @param nums
     */
    private void bucketSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            //若i索引处的元素不是应有的元素，但此元素合法(0<x<length),则将此元素交换到应在的桶位置
            while (nums[i]!=i+1){
                if(nums[i]<=0 || nums[i] > nums.length || nums[i] == nums[nums[i]-1])
                    break;
                swap(nums,i,nums[i]-1);
            }
        }
    }

    /**
     * 交换数组中a,b索引位置的值
     * @param nums
     * @param a
     * @param b
     */
    private void swap(int[] nums,int a,int b){
        if(a>=nums.length || b>=nums.length || a<0 || b <0)
            return;
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(new ProblemFirstMissingPositive().firstMissingPositive(nums));
    }
}
