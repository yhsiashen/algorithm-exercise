package org.yuhang.algorithm.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class ProblemRomantoInteger {

    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case 'I': {
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        res += map.get(s.charAt(i + 1)) - 1;
                        i++;
                    } else {
                        res += 1;
                    }
                    break;
                }
                case 'X': {
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        res += map.get(s.charAt(i + 1)) - 10;
                        i++;
                    } else {
                        res += 10;
                    }
                    break;
                }
                case 'C': {
                    if (i + 1 < s.length() && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        res += map.get(s.charAt(i + 1)) - 100;
                        i++;
                    } else {
                        res += 100;
                    }
                    break;
                }
                default:
                    res += map.get(ch);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemRomantoInteger().romanToInt("MCMXCIV"));
    }
}
