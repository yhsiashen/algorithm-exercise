package org.yuhang.algorithm.leetcode.array;

/**
 * 在排序数组中查找元素的第一个和最后一个位置,要求时间复杂度为O(logn) LC34
 */
public class ProblemFindFirstAndLastPositionOfElementInSortedArray2 {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length ==0 )return new int[]{-1,-1};
        //寻找左边界
        int left = searchLeftBound(nums, target);
        if(left == -1) return new int[]{-1,-1};//没有左边界，直接返回
        //寻找右边界
        int rigth = searchRightBound(nums, target);//有左边界的情况下一定有右边界
        return new int[]{left,rigth};
    }


    private int searchLeftBound(int[] nums,int target){
        int left = 0 ,right = nums.length-1;
        while (left < right){ //注意
            int mid = (left + right)/2;
            if(nums[mid] == target){
                right = mid; // 缩小右边界
            }else if(nums[mid] < target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left = nums[left] == target ? left: -1;

    }

    private int searchRightBound(int[] nums,int target){
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length-1;

        while (left <= right) { //注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 此处需保证有左边界值(即数组中有target值)
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if(right>=0 && nums[right] == target){
            return right;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,6,6,7,9};
        int res = new ProblemFindFirstAndLastPositionOfElementInSortedArray2().searchRightBound(nums,5);
//        for (int i : res){
//            System.out.println(i);
//        }
        System.out.println(res);
    }
}
