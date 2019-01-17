package org.yuhang.algorithm.leetcode.string;

/** 无重复的最长子串 暴力法 3
 * Created by chinalife on 2018/11/26.
 */
public class ProblemLengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        if(s.length()==1)
            return 1;
        int maxLength = 0;
        for (int i = 0; i < s.length() ; i++) {
            for (int j = i+1; j <=s.length(); j++) {
                if(isSubString(s.substring(i,j)) && j-i>maxLength){
                    maxLength = j-i;
                }
            }
        }
        return maxLength;
    }

    private boolean isSubString(String s){
        for (int i = 1; i < s.length(); i++) {
            if(s.substring(0,i).contains(s.substring(i,i+1))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemLengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
