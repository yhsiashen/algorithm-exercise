package org.yuhang.algorithm.leetcode.string;


/**
 * 最后一个单词的长度 LC58
 */
public class ProblemLengthOfLastWord {

    public int lengthOfLastWord(String s) {
       s = s.trim();
       if("".equals(s)) return 0;
       int index = s.lastIndexOf(" ");
       return s.length()-1-index;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemLengthOfLastWord().lengthOfLastWord(""));
    }
}
