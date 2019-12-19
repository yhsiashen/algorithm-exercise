package org.yuhang.algorithm.leetcode.string;


import java.util.Arrays;
import java.util.List;

/**
 * 反转字符串中的元音字母 LC345
 */
public class ProblemReversevowelsofString {

    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        char[] sc = s.toCharArray();
        int a = 0,b = s.length()-1;
        while (a < b) {
            while (a<b && !vowels.contains(s.charAt(a))) {
                a++;
            }
            while (a<b && !vowels.contains(s.charAt(b))) {
                b--;
            }
            swap(sc,a++,b--);
        }

        return new String(sc);
    }

    private void swap(char[] sc, int a, int b) {
        char tmp = sc[a];
        sc[a] = sc[b];
        sc[b] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemReversevowelsofString().reverseVowels("leetcode"));
    }
}
