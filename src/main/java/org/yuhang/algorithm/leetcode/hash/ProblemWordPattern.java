package org.yuhang.algorithm.leetcode.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 单词规律 LC290
 */
public class ProblemWordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        Map<Character,String> map1 = new HashMap<>();
        Map<String,Character> map2 = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char ch = pattern.charAt(i);
            if(!map1.containsKey(ch)){
                map1.put(ch,strs[i]);
            }else{
                if(!strs[i].equals(map1.get(ch))){
                    return false;
                }
            }
        }

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            if(!map2.containsKey(s)){
                map2.put(s,pattern.charAt(i));
            }else{
                if(pattern.charAt(i) != map2.get(s)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemWordPattern().wordPattern("abba","dog cat cat dog"));

    }
}
