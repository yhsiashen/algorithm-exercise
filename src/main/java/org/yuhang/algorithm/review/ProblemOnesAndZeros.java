package org.yuhang.algorithm.review;

/**
 * 一和零 LC474
 */
public class ProblemOnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n){
        int[][] dp = new int[m+1][n+1];//dp[i][j]表示strs数组中不超过i个0且j个1的最大子集大小
        for(String str:strs){
            int[] count = countOnesAndZeros(str);
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if(i >= count[0] && j>=count[1])
                      dp[i][j] = Math.max(dp[i][j], dp[i-count[0]][j-count[1]]+1);
                }
            }
        }
        return dp[m][n];

    }

    private int[] countOnesAndZeros(String str){
        int[] count = new int[2];
        for(char c:str.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }
}
