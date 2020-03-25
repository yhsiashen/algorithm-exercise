package org.yuhang.algorithm.leetcode.math;

/**
 * 最长回文串 LC409
 */
public class ProblemLongestpalindrome {

    public int longestPalindrome(String s) {
        if(s.length() == 0) return 0;
        int res = 0;
        int[] maps = new int[58];
        for (int i = 0; i < s.length(); i++) {
            maps[s.charAt(i) - 'A']++;
        }
        for(int x:maps){
            res += x%2==0?x:x-1;
        }
        return res<s.length()?res+1:res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemLongestpalindrome().longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }
}
