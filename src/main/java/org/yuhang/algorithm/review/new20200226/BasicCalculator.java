package org.yuhang.algorithm.review.new20200226;

import java.util.Stack;

/**
 * 基本计算器
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class BasicCalculator {

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

    public int calculate1(String s){
        Stack<Integer> stack = new Stack<>();
        int sign = 1, res = 0;
        for (int i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num = ch - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + s.charAt(++i)-'0';
                }
                res = res + num*sign;
            }else if(ch == '+'){
                sign = 1;
            }else if(ch == '-'){
                sign = -1;
            }else if(ch == '('){//遇到'('，将之前计算的结果压入栈保存
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if(ch == ')'){//遇到')'，计算结果
                res = res*stack.pop()+stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new BasicCalculator().calculate1(s));
    }
}
