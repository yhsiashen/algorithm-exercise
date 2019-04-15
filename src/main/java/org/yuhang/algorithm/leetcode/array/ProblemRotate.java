package org.yuhang.algorithm.leetcode.array;


/**
 * 空间复杂度为O(1) 旋转数组,将数组中的元素向右移动k个位置  189
 */
public class ProblemRotate {

    /**
     * 旋转k次，时间 O(kn) 空间O(1)
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if(nums ==null || nums.length == 0)
            return;
        int l = nums.length;
        //一次一次旋转
        for (int i = 1; i <= k ; i++) {
            int lastElement = nums[l-1];
            for (int j = l-1; j >0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = lastElement;
        }
    }

    /**
     * 循环交换 时间O(n) 空间O(1)
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if(nums ==null || nums.length == 0)
            return;
        int n = nums.length;
        //对数组长度取余数，则得到需要旋转的最小次数
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
    }

    /**
     * 交换a,b位置的元素
     * @param nums
     * @param a
     * @param b
     */
    private void swap(int[] nums,int a,int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    /**
     * 3次翻转，第一次把整个数组翻转，第二次把0~k-1部分的数组翻转，第三次把k~n部分的数组翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }


    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
    public static void main(String[] args) {
        //       => {5,6,7,1,2,3,4}
       int[] nums = {1,2,3,4,5,6,7};
       new ProblemRotate().rotate3(nums,3);
        for (int i :nums) {
            System.out.print(i);
        }
    }



}
