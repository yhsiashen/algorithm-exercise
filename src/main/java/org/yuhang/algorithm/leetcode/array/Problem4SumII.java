package org.yuhang.algorithm.leetcode.array;

import java.util.HashMap;

/**
 * 4数之和II  LC454
 */
public class Problem4SumII {


    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0) return 0;
        int len = A.length;
        int res=0;
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map1.put(A[i]+B[j],map1.getOrDefault(A[i]+B[j],0)+1);
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = C[i]+D[j];
                if(map1.containsKey(-sum)){
                    res += map1.get(-sum);
                }
            }
        }

        return res;
    }



    public static void main(String[] args) {
        int[] A = {0,1,-1};
        int[] B = {-1,1,0};
        int[] C = {0,0,1};
        int[] D = {-1,1,1};
        System.out.println(new Problem4SumII().fourSumCount(A,B,C,D));
    }
}
