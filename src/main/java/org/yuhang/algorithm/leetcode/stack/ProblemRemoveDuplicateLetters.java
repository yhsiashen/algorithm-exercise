package org.yuhang.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 去除重复字母 LC316
 */
public class ProblemRemoveDuplicateLetters {


    public String removeDuplicateLetters(String s) {
       if(s.length() == 0) return s;
       int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.contains(s.charAt(i))){
                map[s.charAt(i)-'a']--;
                continue;
            }
            while (!stack.isEmpty() && s.charAt(i) < stack.peek() && map[stack.peek()-'a'] > 1){
                map[stack.peek()-'a']--;
                stack.pop();
            }
            stack.push(s.charAt(i));
        }


        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ProblemRemoveDuplicateLetters().removeDuplicateLetters("abacb"));
    }
}
