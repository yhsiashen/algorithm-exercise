package org.yuhang.algorithm.interview;

/**
 * 翻译数字
 */
public class ProblemTranslateNum {

    public int translateNum(int num) {
        String nums = String.valueOf(num);
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1];
            int cur = nums.charAt(i)-'0';
            int before = nums.charAt(i-1)-'0';
            if(before <= 1||(before == 2 && cur <=5)){//当前数字和前面数字组合可成10~25的情况
                if(i>1) dp[i] = dp[i-1]+dp[i-2];
                else dp[i] = dp[i-1]+1;
            }
        }
        return dp[nums.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new ProblemTranslateNum().translateNum(18580));
    }
}
