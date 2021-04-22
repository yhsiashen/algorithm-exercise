package org.yuhang.algorithm.review.new20200226;

import java.util.Stack;

/**
 * 有效的括号
 * 输入：s = "{[]}"
 * 输出：true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
       if(s.length() == 1) return false;
       Stack<Character> stack = new Stack<>();
       for (int i = 0; i < s.length(); i++) {
           char ch = s.charAt(i);
           if(ch == '(' || ch == '[' || ch == '{'){
               stack.push(ch);
           }else{
               if(stack.isEmpty() || !ifMatch(stack.pop(),ch)){
                   return false;
               }
           }
       }
       return stack.isEmpty();
    }

    private boolean ifMatch(char ch1, char ch2){
        if(ch1 == '('){
            return ch2 == ')';
        }else if(ch1 == '['){
            return ch2 == ']';
        }else{
            return ch2 == '}';
        }
    }
}
