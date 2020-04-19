package org.yuhang.algorithm.review;

/**
 * 无重复字符的最长子串 LC3
 */
public class LongestSubstringWithoutRepeatingCharactersProblem {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        int[] maps = new int[128];
        int l=0,r=0;
        while (r < s.length()){
            int idx = s.charAt(r);
            maps[idx]++;
            while (maps[idx] > 1){//当窗口中有值大于1时，移动左窗口直至重新满足无重复的条件
                maps[s.charAt(l)]--;
                l++;
            }
            r++;
            ans = Math.max(ans, r-l);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharactersProblem().lengthOfLongestSubstring("pwwkew"));
    }
}
