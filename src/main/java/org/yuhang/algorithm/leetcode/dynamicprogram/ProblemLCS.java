package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.Stack;

/**  最长公共子序列
 * Created by chinalife on 2018/12/10.
 */
public class ProblemLCS {

    /**
     * 求最长公共子序列长度
     * @param a
     * @param b
     * @return
     */
    public int LCS(String a,String b){
        if(a==null || b==null){
            return 0;
        }
        int la = a.length();
        int lb = b.length();

        int[][] dp = new int[la+1][lb+1]; // dp[i][j] 表示长度为i的字符串a和长度为j的字符串b的最长公共子序列长度
        for (int i = 0; i < la+1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < lb+1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < la+1; i++) {
            for (int j = 1; j < lb+1; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[la][lb];
    }

    /**
     * 求最长公共子序列
     * @param a
     * @param b
     * @return
     */
    public String LCS1(String a,String b){
        if(a==null || b==null)
            return null;
        int la = a.length();
        int lb = b.length();
        StringBuilder res = new StringBuilder();

        int[][] dp = new int[la+1][lb+1]; // dp[i][j] 表示长度为i的字符串a和长度为j的字符串b的最长公共子序列长度
        for (int i = 0; i < la+1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < lb+1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < la+1; i++) {
            for (int j = 1; j < lb+1; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        int LCS = dp[la][lb];
        while (stack.size()!=LCS){ //从dp数组的最后一个元素倒推,遇到相等的元素加入栈,不相等的元素则找寻之前较大的dp值
            if(a.charAt(la-1) == b.charAt(lb-1)){
                stack.push(a.charAt(la-1));
                la--;
                lb--;
            }else{
                if(dp[la-1][lb] >= dp[la][lb-1]){
                    la--;
                }else{
                    lb--;
                }
            }

        }

        while (!stack.isEmpty()){
            res.append(stack.pop());
        }

     return res.toString();
    }

    public static void main(String[] args) {
        String a= "AAACDB";
        String b= "ABACBDCB";
        System.out.println(new ProblemLCS().LCS1(a,b));
    }


}
