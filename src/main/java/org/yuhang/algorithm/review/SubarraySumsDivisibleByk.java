package org.yuhang.algorithm.review;

import java.util.HashMap;

/**
 * 和可被k整除的子数组
 */
public class SubarraySumsDivisibleByk {

    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int res = 0;
//        K = Math.abs(K);
        int[] map = new int[K];
        map[0] = 1;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int key = (sum%K+K)%K;
            res += map[key];
            map[key]++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,-2,2,-4};
        System.out.println(new SubarraySumsDivisibleByk().subarraysDivByK(A,6));
//        System.out.println(-1%2);
    }
}
