package org.yuhang.algorithm.review;

/**
 * 荷兰国旗问题 LC75
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int len = nums.length;
        if(len < 2) return;
        int zero = 0;//表示0元素的位置
        int two = len;//表示2元素的位置
        int i = 0;//表示1元素的位置
        while (i < two){
            if(nums[i]==0){
               swap(nums,i,zero);
               zero++;
               i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                two--;
                swap(nums,i,two);
            }

        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
