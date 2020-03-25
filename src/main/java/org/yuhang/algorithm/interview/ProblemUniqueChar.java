package org.yuhang.algorithm.interview;

/**
 * 第一个只出现一次的字符
 */
public class ProblemUniqueChar {

    public char firstUniqChar(String s) {
        if(s.length() == 0) return ' ';
        int[] maps = new int[26];
        for(int i=0;i<s.length();i++){
            maps[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(maps[s.charAt(i)-'a'] == 1) return s.charAt(i);
        }
        return ' ';
    }

}
