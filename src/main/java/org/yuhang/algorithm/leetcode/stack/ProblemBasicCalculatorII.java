package org.yuhang.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 基本计算器II 227
 */
public class ProblemBasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>(); //数字栈
        char c = '+'; // 表示之前最近的一个符号
        int res = 0,cur=0;
        s = s.replaceAll(" ","");
        for (int i = 0; i < s.length(); i++) {
             char ch  = s.charAt(i);
             if(Character.isDigit(ch)){ //检索后面的字符是否也是数字
                 cur = Character.getNumericValue(ch);
                 while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                     cur = cur*10-'0'+s.charAt(++i); //先做减法，避免整数溢出
                 }
             }
             if(!Character.isDigit(ch) || i == s.length()-1){
                 switch (c){
                     case '+':
                         stack.push(cur);
                         break;
                     case '-':
                         stack.push(-cur);
                         break;
                     case '*':
                         stack.push(cur*stack.pop());
                         break;
                     case '/':
                         stack.push(stack.pop()/cur);
                         break;
                 }

                 c = ch; // 记录这次符号
                 cur = 0;
             }
        }

        while (!stack.isEmpty()) res+=stack.pop();
        return res;
    }

    public static void main(String[] args) {
           String reg = "42";
        System.out.println(new ProblemBasicCalculatorII().calculate(reg));

    }
}
