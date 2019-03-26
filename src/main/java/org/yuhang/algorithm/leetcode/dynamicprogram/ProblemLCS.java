package org.yuhang.algorithm.leetcode.dynamicprogram;

/**  最长公共子序列(长度和序列)
 * Created by chinalife on 2018/12/10.
 */
public class ProblemLCS {

    public int LCS(String a,String b){
        if(a==null || b==null){
            return 0;
        }
        int la = a.length();
        int lb = b.length();

        int[][] dp = new int[la][lb];
        for (int i = 0; i < la; i++) {
            for (int j = 0; j < lb; j++) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        return dp[la-1][lb-1];
    }

    public String LCS1(String a,String b){
        if(a==null || b==null)
            return null;
        int la = a.length();
        int lb = b.length();
//        StringBuilder result = new StringBuilder();
        String[][] result = new String[la][lb];
        for (int i = 0; i < la; i++) {
            for (int j = 0; j < lb; j++) {
                if(i==0||j==0){
                   result[i][j] ="";
                }else if(a.charAt(i) == b.charAt(j)){
                    result[i][j] = result[i-1][j-1] + a.charAt(i);
                }else {
                    result[i][j] = result[i][j-1].length()>result[i-1][j].length()?
                                      result[i][j-1]:result[i-1][j];
                }
            }

        }

        return result[la-1][lb-1];

    }

    public static void main(String[] args) {
        String a= "AAACDB";
        String b= "ABACBDCB";
        System.out.println(new ProblemLCS().LCS1(a,b));
    }


}
