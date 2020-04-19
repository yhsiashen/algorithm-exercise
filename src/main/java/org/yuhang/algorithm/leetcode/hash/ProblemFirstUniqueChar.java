package org.yuhang.algorithm.leetcode.hash;

/**
 * 字符串中第一个唯一字符 LC387
 */
public class ProblemFirstUniqueChar {

    public int firstUniqChar(String s) {
       int[] maps = new int[127];
        for (int i = 0; i <s.length() ; i++) {
            maps[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(maps[s.charAt(i)] == 1){
                return i;
            }
        }
        return -1;

    }
}
