package org.yuhang.algorithm.leetcode.backtracealgo;


/**
 * 正则表达式匹配  回溯算法 10
 */
public class ProblemRegularExpressionMatch {


    /**
     * 动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s,String p){
        int slength = s.length();
        int plength = p.length();
        //考虑到s和p都可以为空，则用dp[i][j] 表示 s.substring[0,i) 与 p.substring[0,j)是否匹配
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


    /**
     * 回溯法
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch1(String s,String p){
        //1.pattern为空且string为空，则返回正确，否则返回错误
        if(p.isEmpty())
            return s.isEmpty();
        //2.若都只有一个字符,则看是否匹配或pattern是否为'.'
        if(p.length() == 1){
            return (s.length() == 1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'));
        }
        //3.若长度大于1且第2个字符不为*,则观察第一个字符是否匹配并递归匹配后面的子串
        if(p.charAt(1)!='*'){
            if(s.isEmpty()) return false;
            //若pattern和string的第一个字符匹配，则递归继续看后面子串的匹配情况
            return (p.charAt(0) == s.charAt(0) || p.charAt(0) =='.') && isMatch1(s.substring(1),p.substring(1));
        }
        //4.若长度大于1且第二个字符为*，且首字符匹配
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0)|| p.charAt(0) == '.')){
            //验证*的作用是否让前面的字符出现0次，故p直接从第三个字符开始匹配,若成功，则直接返回true
            if(isMatch1(s,p.substring(2))) return true;
            s = s.substring(1);
        }
        //5.若首字符不匹配，则要么正则不匹配，要么是第二个字符为*，故p直接从第三个字符开始匹配，以排除这种情况
        return isMatch1(s,p.substring(2));

    }

    public static void main(String[] args) {
        System.out.println(new ProblemRegularExpressionMatch().isMatch("",".*"));
    }
}
