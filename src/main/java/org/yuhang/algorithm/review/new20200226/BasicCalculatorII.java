package org.yuhang.algorithm.review.new20200226;

import java.util.Stack;

/**
 * 基本计算器
 *
 * 输入：s = "3-2*2"
 * 输出：7
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 */
public class BasicCalculatorII {

    public int calculate(String s) {
        if(s.length() == 1) return Integer.parseInt(s);
        s = s.replaceAll(" ","");
        Stack<Integer> stack = new Stack<>();
        char sigh = '+';//表示最近的符号，初始值为'+'
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = ch - '0';
                while (i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(++i) - '0';
                }
            }
            if(!Character.isDigit(ch)||i == s.length()-1){
                switch(sigh){
                    case '+':
                      stack.push(num);
                      break;
                    case '-':
                      stack.push(-num);
                      break;
                    case '*':
                      stack.push(stack.pop() * num);
                      break;
                    case '/':
                      stack.push(stack.pop() / num);
                      break;
                }
                sigh = ch;
                num = 0;
            }
        }

        while (!stack.isEmpty()){
            num += stack.pop();
        }

        return num;
    }

    public static void main(String[] args) {
        String s = "3-2*2";
        System.out.println(new BasicCalculatorII().calculate(s));
    }


}
