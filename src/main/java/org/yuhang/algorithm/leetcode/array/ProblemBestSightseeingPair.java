package org.yuhang.algorithm.leetcode.array;

/**
 * 最佳观光组合 LC1014
 */
public class ProblemBestSightseeingPair {

    /**
     * A[i]+A[j]+i-j = A[i]+i+A[j]-j
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        if(A.length == 0) return 0;
        int res=0;
        int pre_max = A[0];
        for (int j = 1; j < A.length ; j++) {
            res = Math.max(res,pre_max+A[j]-j);//pre_max表示A[j]之前A[i]+i的最大值
            pre_max = Math.max(pre_max,A[j]+j);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {8,1,5,2,6};
        System.out.println(new ProblemBestSightseeingPair().maxScoreSightseeingPair(A));
    }
}
