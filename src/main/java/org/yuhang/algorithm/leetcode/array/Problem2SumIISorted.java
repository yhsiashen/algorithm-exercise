package org.yuhang.algorithm.leetcode.array;


/**
 * 两数之和 II LC167
 */
public class Problem2SumIISorted {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int b = findByBinarySearch(numbers,i+1,numbers.length-1,target-numbers[i]);
            if(b != -1){
                return new int[]{i+1,b+1};
            }
        }
        return null;
    }

    private int findByBinarySearch(int[] numbers,int a,int b,int target){
           while (a <= b){
               int mid = (a+b)/2;
               if(numbers[mid]<target){
                   a = mid+1;
               }else if(numbers[mid] > target){
                   b = mid-1;
               }else {
                   return mid;
               }
           }
           return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,25,75};
        int[] res = new Problem2SumIISorted().twoSum(nums,100);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
