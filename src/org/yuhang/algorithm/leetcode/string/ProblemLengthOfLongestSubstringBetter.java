package org.yuhang.algorithm.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**无重复的最长子串 滑动窗口法 3
 * Created by chinalife on 2018/11/26.
 */
public class ProblemLengthOfLongestSubstringBetter {


    public int lengthOfLongestSubstring(String s) {
      int n = s.length();
      //用一个set集合做无重复的子串的滑动窗口
      Set<Character> set = new HashSet<>();
      int maxLength = 0;
      int i=0,j=0;
      while (i<n && j<n){
          if(!set.contains(s.charAt(j))){
              set.add(s.charAt(j));
              maxLength = maxLength>j-i+1?maxLength:j-i+1;
              j++;
          }else {
              set.remove(s.charAt(i++));
          }
      }
      return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("abc".charAt(0));
    }
}
