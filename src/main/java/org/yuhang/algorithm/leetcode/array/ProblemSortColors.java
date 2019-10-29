package org.yuhang.algorithm.leetcode.array;


/**
 * 颜色分类 LC75
 * @tag:双指针
 */
public class ProblemSortColors {


    /**
     * 双指针
     * @param nums
     */
    public void sortColors(int[] nums) {
       if(nums.length <=1) return;
       int red = -1,blue = -1;
       for (int i = 0; i < nums.length; i++) {
          if(nums[i] == 0){ //该数字是红色
              if(red == -1){ //第一次遇到红色,和索引0交换位置
                  swap(nums,0,i);
                  red = 0; //最右红色索引为0
              }else{ //不是第一次遇到红色，则交换i与red+1位置
                  swap(nums,++red,i);
              }
          }else if(nums[i] == 2){ //该数字为蓝色
              if(blue == -1){ //第一次遇到蓝色，和最后一个数字交换位置
                  swap(nums,nums.length-1,i);
                  blue = nums.length-1;
                  //若交换过来的是红色或蓝色，需特殊处理
                  if(nums[i] == 0 || nums[i] == 2) i--;
              }else if(i < blue){ //不是第一次遇到蓝色，且i还没到blue位置,则交换i与blue-1位置
                  swap(nums,--blue,i);
                  //若交换过来的是红色或蓝色，需特殊处理
                  if(nums[i] == 0 || nums[i] == 2) i--;
              }
          }
       }
    }

    /**
     * 双指针简化版
     * @param nums
     */
    public void sortColors2(int[] nums) {

        int zero = -1; //哨兵元素
        int two = nums.length;//哨兵元素

        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, --two);
            } else {
                swap(nums, ++zero, i);
                i++;
            }
        }

    }

    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2};
        new ProblemSortColors().sortColors(nums);
    }
}
