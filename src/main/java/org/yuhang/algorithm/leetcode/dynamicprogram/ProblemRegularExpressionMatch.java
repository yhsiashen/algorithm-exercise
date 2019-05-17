package org.yuhang.algorithm.leetcode.dynamicprogram;


/**
 * 正则表达式匹配 10
 */
public class ProblemRegularExpressionMatch {


    /**
     * 二维动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s,String p){
        if(p.isEmpty())
            return s.isEmpty();
        int slength = s.length();
        int plength = p.length();
        //dp[i][j] 表示 s.substring[0,i) 与 p.substring[0,j)是否匹配
        boolean[][] dp = new boolean[slength+1][plength+1];
        //初始化s,p都为空时能匹配,p为空时都无法匹配s
        dp[0][0] = true;
        for (int i = 0; i <= slength; i++) {
            for (int j = 1; j <= plength; j++) {
                if(j >1 && p.charAt(j-1)=='*'){
                    //j为'*'的情况分两种: 1.*前面的元素可以为0个，即为dp[i][j-2]；2.s的i位置元素等于*前面的元素或者*前面的元素为. ,再&上dp[i-1][j]
                    dp[i][j] = ( dp[i][j-2]) || (i>0 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
                }else{
                    dp[i][j] = (i>0 && p.charAt(j-1) == '.' && dp[i-1][j-1]) || (i>0 && p.charAt(j-1) == s.charAt(i-1) && dp[i-1][j-1]);
                }
            }
        }

        return dp[slength][plength];
    }
}
