package org.yuhang.algorithm.leetcode.array;


/**
 * 合并两个有序数组
 */
public class ProblemMergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int[] nums3 = new int[nums1.length];
       int k1=0,k2=0,k3=0;
       while ( m >0 && n >0){
           if(nums1[k1]>=nums2[k2]){
               nums3[k3]=nums2[k2];
               k2++;
               k3++;
               n--;
           }else{
               nums3[k3] = nums1[k1];
               k1++;
               k3++;
               m--;
           }

       }

       while (m >0){
           nums3[k3] = nums1[k1];
           k1++;
           k3++;
           m--;
       }

       while (n >0){
            nums3[k3] = nums2[k2];
            k2++;
            k3++;
            n--;
        }

       System.arraycopy(nums3,0,nums1,0,nums3.length);
        System.out.println(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0,0};
        int[] nums2 = {2,5,6};
        new ProblemMergeSortedArray().merge(nums1,3,nums2,3);
    }
}
