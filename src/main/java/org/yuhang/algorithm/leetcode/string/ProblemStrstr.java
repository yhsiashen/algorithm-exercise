package org.yuhang.algorithm.leetcode.string;

/**
 * 实现strStr() LC28
 */
public class ProblemStrstr {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;
        for (int i = 0; i < haystack.length() - needle.length()+1; i++) {
            if (needle.charAt(0) == haystack.charAt(i)) {
                int j = 1, k = i + 1;
                while (j < needle.length() && k < haystack.length() && needle.charAt(j) == haystack.charAt(k)) {
                    j++;
                    k++;
                }
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }


        public static void main(String[] args) {
        System.out.println(new ProblemStrstr().strStr("hello","ll"));
    }
}
