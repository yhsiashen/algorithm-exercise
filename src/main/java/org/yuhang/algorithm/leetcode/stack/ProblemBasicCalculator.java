package org.yuhang.algorithm.leetcode.stack;


import java.util.Stack;

/**
 * 实现一个基本计算器 224
 */
public class ProblemBasicCalculator {

    /**
     * 只用一个数字栈
     * @param s
     * @return
     */
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

    /**
     * 符号栈和数字栈
     * @param s
     * @return
     */
    public int calculate1(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int num = Character.getNumericValue(ch);
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                    num = num * 10 + Character.getNumericValue(s.charAt(++i));
                }
                if (!charStack.isEmpty() && charStack.peek() != '('){
                    int a = numStack.pop();
                    char chr = charStack.pop();
                    int res = chr == '+' ? a +num : a - num;
                    numStack.push(res);
                }else{
                    numStack.push(num);
                }
            }else if(ch == '+' || ch == '-' || ch =='('){
                charStack.push(ch);
            }else if(ch == ')'){//遇到右括号时，弹出左括号，然后计算邻近的表达式的值
                charStack.pop();//弹出栈顶的左括号
                if (!charStack.isEmpty() && charStack.peek()!='('){//若此时符号栈顶不是左括号，则计算一次表达式的值并再次压入数字栈
                    int b = numStack.pop();
                    char chr = charStack.pop();
                    int a = numStack.pop();
                    int res = chr=='+'?a+b:a-b;
                    numStack.push(res);
                }
            }
        }

        return numStack.pop();
    }

    public static void main(String[] args) {
//        String s="1-11";
//        System.out.println(new ProblemBasicCalculator().calculate(s));
        char ch = '3';
        int b = (int)ch;
        System.out.println(b);

    }
}
