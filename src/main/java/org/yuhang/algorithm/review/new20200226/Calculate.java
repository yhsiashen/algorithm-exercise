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
       s.replace(" ","");
       for (int i = 0; i < s.length();) {
          char ch  = s.charAt(i);
          if(ch == ' '){

          }else if(ch == '+' || ch == '-'){
              charStack.offer(ch);
          }else if(Character.isDigit(ch)){
              int num = ch - '0';
              while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
                  num = num * 10 + (s.charAt(i+1)-'0');
                  i++;
              }
              numStack.offer(num);
          }else{//为"*"或者"/"
              int nextInt = s.charAt(i) - '0';
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

    public static void main(String[] args) {
        String str = "1*2-3/4+5*6-7*8+9/10";
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate(str));
    }
}
