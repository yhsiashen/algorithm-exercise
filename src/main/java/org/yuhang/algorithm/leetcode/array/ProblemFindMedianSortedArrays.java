package org.yuhang.algorithm.leetcode.array;


/**
 * 寻找两个有序数组中的中位数，要求O(log(m+n))
 */
public class ProblemFindMedianSortedArrays {

    /**
     * 普通做法  O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int len = nums1.length+nums2.length;
       int[] mergeNums = new int[len];
       int i1=0;
       int i2=0;
        for (int i =0; i < len; i++) {
            //若nums1和nums2都还没遍历到结尾
            if(i1<nums1.length && i2<nums2.length){
                if(nums1[i1] < nums2[i2]) mergeNums[i] = nums1[i1++];
                else mergeNums[i] = nums2[i2++];
                continue;
            }

            //若nums2遍历完
            if(i1<nums1.length)  {
                mergeNums[i] = nums1[i1++];
                continue;
            }
            //若nums1遍历完
            if(i2<nums2.length) {
                mergeNums[i] = nums2[i2++];
            }
        }
     double result;
     if(len%2==0){
         result = ((double) mergeNums[len / 2] + (double) mergeNums[len / 2 - 1])/2;
     }else {
         result = (double) mergeNums[len/2];
     }
     return result;
    }




    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(new ProblemFindMedianSortedArrays().findMedianSortedArrays(nums1,nums2));
    }
}
