package org.yuhang.algorithm.interview;


/**
 * 最长不包含重复字符的子字符串
 */
public class ProblemLengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
       if(s.length() == 0) return 0;
       int res = 0;
       int i=0,j=0;
       int[] windowMap = new int[128];
       while (j<s.length()){
           windowMap[s.charAt(j)]++;
           while (windowMap[s.charAt(j)]>1){
               windowMap[s.charAt(i)]--;
               i++;
           }
           res = Math.max(res,j-i+1);
           j++;
       }
       return res;
    }


}
