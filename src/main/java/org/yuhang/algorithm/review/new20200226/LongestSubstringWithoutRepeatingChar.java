package org.yuhang.algorithm.review.new20200226;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int l = 0, r= 0;
        int max = -1;
        HashMap<Character,Integer> windowMap = new HashMap<>();
        //滑动窗口 l~r ，当滑动窗口内的子串不重复时，增加窗口大小直到重复，然后缩小
        while (r < s.length()){
             char ch = s.charAt(r);
             windowMap.put(ch, windowMap.getOrDefault(ch,0)+1);
             while (windowMap.get(ch) == 2){//如果ch字符重复了，则增大l直到ch不重复
                 windowMap.put(s.charAt(l), windowMap.getOrDefault(s.charAt(l),0)-1);
                 l++;
             }

             if(r-l+1 > max){
                  max = r-l+1;
              }
             r++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s=  "pwwkew";
        System.out.println(new LongestSubstringWithoutRepeatingChar().lengthOfLongestSubstring(s));
    }
}
