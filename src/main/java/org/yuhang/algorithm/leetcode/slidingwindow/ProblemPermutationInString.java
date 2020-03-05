package org.yuhang.algorithm.leetcode.slidingwindow;

/**
 * 字符串的排列 LC567
 * @tag:滑动窗口
 */
public class ProblemPermutationInString {

    /**
     * 滑动窗口比较窗口内字符的频率与s1的字符频率是否一致，不一致则滑动窗口
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int window = s1.length();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < window; i++) {
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        for (int i = window; i < s2.length(); i++) {
           if(matches(map1,map2)) return true;
           map2[s2.charAt(i)-'a']++;//i位置元素加入窗口
           map2[s2.charAt(i-window)-'a']--;//最左边元素移除窗口
        }

        return matches(map1,map2);
    }

    private boolean matches(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if(map1[i]!=map2[i]) return false;
        }
        return true;
    }
}
