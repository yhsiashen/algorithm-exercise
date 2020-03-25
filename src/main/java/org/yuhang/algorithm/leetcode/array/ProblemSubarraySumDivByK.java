package org.yuhang.algorithm.leetcode.array;

/**
 * 和可被K整除的子数组 LC974
 */
public class ProblemSubarraySumDivByK {

    /**
     * 前缀和+hash表
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        if(A.length == 0) return 0;
        int res = 0;
        int[] preSums = new int[A.length+1];//前缀和数组
        for (int i = 0; i < preSums.length-1; i++) {
            preSums[i+1] = preSums[i]+ A[i];
        }
        int[] map = new int[K];//存 presum%K 的值

        for (int preSum : preSums) {
            int key = (preSum % K + K) % K;
            res += map[key];
            map[key]++;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemSubarraySumDivByK().subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
}
