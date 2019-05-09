package org.yuhang.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 找到两个字符串的不同字符  389
 */
public class ProblemFindTheDifference {

    /**
     * 把两个字符串的所有字符分别相加，再做减法即得到多余的字符
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char c = '0';
        for (int i = 0; i < s.length(); i++) {
           c = (char) (c+s.charAt(i));
        }

        char d = '0';
        for (int i = 0; i < t.length(); i++) {
             d = (char) (d+t.charAt(i));
        }
        return (char) (d-c);
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aaa";
        ProblemFindTheDifference p = new ProblemFindTheDifference();
        System.out.println(p.findTheDifference(s,t));
    }
}
