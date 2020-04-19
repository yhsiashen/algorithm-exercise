package org.yuhang.algorithm.review;

/**
 * 最长回文子串 LC5
 */
public class LongestPalindromicSubstringProblem {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int l = s.length();
        int start = 0,right = 0;
        int max = 0;
        if(l==0) return "";
        boolean[][] dp = new boolean[l][l];//dp[i][j]表示s.substr(i,j)是否为回文串
        for (int i = l-1; i >= 0 ; i--) {
            for (int j = i; j < l ; j++) {
                if(i == j){
                    dp[i][j] = true;
                }else if(i<j){
                    dp[i][j] = j-i>=2? (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) : s.charAt(i) == s.charAt(j);
                    if(dp[i][j] && j-i+1>max){
                        start = i;
                        right = j;
                        max = j-i+1;
                    }
                }
            }
        }
        return s.substring(start,right+1);
    }

    public String longestPalindrome1(String s) {
        String result = "";
        int[] limit = {0, 0};
        char[] ch = s.toCharArray();
        int i = 0;
        while(i < ch.length){
            i = indexOf(ch, i, limit);
        }
        result = s.substring(limit[0], limit[1]);
        return result;

    }
    //找到一个点，往中心扩展
    private int indexOf(char[] ch, int low, int[] limit) {
        // TODO Auto-generated method stub
        int high = low + 1;
        while(high < ch.length && ch[high] == ch[low]){
            high++;
        }
        int result = high;
        while(low > 0 && high < ch.length && ch[low - 1] == ch[high]){
            low--;
            high++;
        }
        if((high - low) > limit[1] - limit[0]){
            limit[0] = low;
            limit[1] = high;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstringProblem().longestPalindrome("cbbd"));
    }
}
