package org.yuhang.algorithm.leetcode.stack;


import java.util.Stack;

/**
 * 实现一个基本计算器 224
 */
public class ProblemBasicCalculator {

    public int calculate(String s) {
            Stack<Integer> stack = new Stack<Integer>();

            int sign = 1, res = 0;// sign 代表正负
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    int cur = ch - '0';
                    while (i + 1 < length && Character.isDigit(s.charAt(i + 1)))
                        cur = cur * 10 + s.charAt(++i) - '0';
                    res = res + sign * cur;
                } else if (ch == '+') {
                    sign = 1;
                } else if (ch == '-') {
                    sign = -1;
                } else if (ch == '(') {
                    stack.push(res);
                    res = 0;
                    stack.push(sign);
                    sign = 1;
                } else if (ch == ')') {
                    res = stack.pop() * res + stack.pop();
                }
            }
            return res;
    }

    public static void main(String[] args) {
//        String s="1-11";
//        System.out.println(new ProblemBasicCalculator().calculate(s));
        char ch = '3';
        int b = (int)ch;
        System.out.println(b);

    }
}
