package org.yuhang.algorithm.leetcode.slidingwindow;

/**
 * 最长湍流子数组 LC978
 * @tag:滑动窗口
 * @tag:动态规划
 */
public class ProblemLongestTurbulentSubarray {

    /**
     * 滑动窗口
     * @param A
     * @return
     */
    public int maxTurbulenceSize(int[] A) {
        if(A.length == 0) return 0;
        if(A.length == 1) return 1;
        int res = 1;
        int left = 0,right = 1;
        while (right < A.length){
            if(A[right]==A[right-1]){
                res = Math.max(res, right-left);
                left = right;//滑动窗口不能包括等于的元素
                right++;
            }else if(A[right] > A[right-1]){
                if(right-1 == 0){
                    right++;
                }else{
                    if(A[right-1] > A[right-2]){
                        res = Math.max(res, right-left);
                        left = right-1;
                        right++;
                    }else {
                        right++;
                    }
                }
            }else if(A[right] < A[right-1]){
                if(right-1 == 0){
                    right++;
                }else{
                    if(A[right-1] < A[right-2]){
                        res = Math.max(res, right-left);
                        left = right-1;
                        right++;
                    }else{
                        right++;
                    }

                }
            }
        }
        res = Math.max(res , right-left);//计算最后一次滑块长度
        return res;
    }

    /**
     * 动态规划
     * @param A
     * @return
     */
    public int maxTurbulenceSize1(int[] A) {
        if(A.length == 0) return 0;
        if(A.length == 1) return 1;
        int[] dp = new int[A.length];//dp[i]表示以A[i]结尾(dp的含义一定要以A[i]结尾)的数组的最长湍流子数组的长度
        int res = 0;
        dp[0] = 1;
        dp[1] = A[1]==A[0]?1:2;
        for (int i = 2; i < A.length; i++) {
            if((A[i-1] <A[i] && A[i-1] > A[i-2]) || (A[i-1] > A[i] && A[i-1] < A[i-2])) {
                dp[i] = dp[i - 1] + 1;
            }else if(A[i] == A[i-1]){
                dp[i] = 1;
            }else {
                dp[i] = 2;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
