package org.yuhang.algorithm.leetcode.array;


import org.yuhang.algorithm.leetcode.array.Array;

import java.util.*;

/**
 * 求两个数组的交集 LC349
 */
public class ProblemIntersectionOfTwoArrays {


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> interSet = new HashSet<>();
        for (int i:nums1){
            set.add(i);
        }

        for (int i:nums2){
            if(set.contains(i)){
                interSet.add(i);
            }
        }

        int[] res = new int[interSet.size()];
        Iterator iterator = interSet.iterator();
        int cnt = 0;
        while (iterator.hasNext()){
            res[cnt++] = (int)iterator.next();
        }
        return res;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> interSet = new HashSet<>();
        int i=0,j=0;
        while (i< nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                interSet.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else {
                j++;
            }
        }

        int[] res = new int[interSet.size()];
        Iterator iterator = interSet.iterator();
        int cnt = 0;
        while (iterator.hasNext()){
            res[cnt++] = (int)iterator.next();
        }
        return res;

    }
}
