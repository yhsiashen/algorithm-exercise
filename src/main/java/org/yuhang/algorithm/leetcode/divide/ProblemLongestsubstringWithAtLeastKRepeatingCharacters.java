package org.yuhang.algorithm.leetcode.divide;

/**
 * 至少有k个重复字符的最长子串 LC395
 * @tag:分治法
 */
public class ProblemLongestsubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        if(s.length()==0||s.length()<k) return 0;
        if(k<2) return s.length();


        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }

        int i =0;
        while (i<s.length() && counts[s.charAt(i)-'a']>=k) i++;
        if(i==s.length()) return s.length();

        int l = longestSubstring(s.substring(0,i),k);//递归找0~i区间的最长子串
        int r = longestSubstring(s.substring(i+1),k);//递归找i+1~length区间的最长子串
        return Math.max(l,r);


    }
}
