package org.yuhang.algorithm.leetcode.string;


import java.util.Stack;

/**
 * 翻转字符串中的单词 LC151
 */
public class ProblemReverseWordsInString {

    public String reverseWords(String s) {
       s = s.trim();
       if( "".equals(s)) return s;
       StringBuilder res = new StringBuilder();
       Stack<String> stack = new Stack<>();
       int i = 0;
       while (i<s.length()){
            StringBuilder tmp=new StringBuilder();
            while (i<s.length() && s.charAt(i)!=' '){
                tmp.append(s.charAt(i++));
            }
            while (i<s.length() && s.charAt(i)==' '){
                i++;
            }
            stack.push(tmp.toString());
        }
       while (!stack.isEmpty()){
           res.append(stack.pop()).append(" ");
       }
       return res.toString().substring(0,res.length()-1);
    }

    public static void main(String[] args) {
//        System.out.println(new ProblemReverseWordsInString().reverseWords(" "));
        String[] words = "hELlo__world??_   Hahah".split("[a-z_]+");
        for(String str:words){
            System.out.println(str);
        }
    }
}
