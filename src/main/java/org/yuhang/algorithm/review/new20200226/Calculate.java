package org.yuhang.algorithm.review.new20200226;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 计算器
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分
 *
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 */
public class Calculate {

    public int calculate(String s) {
       Deque<Integer> numStack = new LinkedList<>();
       Deque<Character> charStack = new LinkedList<>();
       s=s.replace(" ","");
       for (int i = 0; i < s.length();) {
          char ch  = s.charAt(i);
          if(ch == '+' || ch == '-'){
              charStack.offer(ch);
          }else if(Character.isDigit(ch)){
              int num = ch - '0';
              while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                  num = num * 10 + (s.charAt(i+1)-'0');
                  i++;
              }
              numStack.offer(num);
          }else{//为"*"或者"/"
              int nextInt = s.charAt(++i) - '0';
              while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                  nextInt = nextInt * 10 + (s.charAt(i+1)-'0');
                  i++;
              }
              int preInt = numStack.pollLast();
              int x = 0;
              if(ch == '*'){
                  x = preInt * nextInt;
              }else if(ch == '/'){
                  x = preInt / nextInt;
              }
              numStack.offer(x);
          }
          i++;
       }
       while (!charStack.isEmpty()){
           char symbol = charStack.poll();
           int preInt = numStack.poll();
           int nextInt = numStack.poll();
           int x = 0;
           if(symbol == '+'){
               x = preInt + nextInt;
           }else if(symbol == '-'){
               x = preInt - nextInt;
           }
           numStack.push(x);
       }
       return numStack.pop();
    }

    public int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        char symbol = '+';//表示最近的运算符号
        int num = 0;
        s = s.replace(" ","");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + ch - '0';
            }

            if(!Character.isDigit(ch) || i == s.length() -1){
                switch (symbol){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop()/num);
                        break;
                }
                symbol = ch;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String str = " 3+5 / 2 ";
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate(str));
    }
}
