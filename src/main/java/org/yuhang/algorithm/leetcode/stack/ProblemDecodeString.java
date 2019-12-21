package org.yuhang.algorithm.leetcode.stack;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 字符串解码 LC394
 */
public class ProblemDecodeString {


    public String decodeString(String s) {
        Stack<Integer> dupStack = new Stack<>();
        Deque<String> strDeque = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <s.length(); i++) {
            String str = s.substring(i,i+1);
           if(Character.isDigit(str.charAt(0))){
               int j = i+1;
               while (Character.isDigit(s.charAt(j))){
                   j++;
               }
               int dupNum = Integer.parseInt(s.substring(i,j));
               i = j-1;
               dupStack.push(dupNum);
           }else if("]".equals(str)){//遇到"]"时应出栈，范围为[ ~ ]之间的字母
               Stack<String> tmpStack = new Stack<>();
               StringBuilder tmpStr = new StringBuilder();
               while (!"[".equals(strDeque.peekLast())){
                   tmpStack.push(strDeque.pollLast());
               }
               strDeque.pollLast();//弹出"["
               while (!tmpStack.isEmpty()){
                   tmpStr.append(tmpStack.pop());
               }
               int dup = 0;
               if (!dupStack.isEmpty()) {
                   dup = dupStack.pop();
               }
               while (dup>0) { //压入dup次栈
                   dup--;
                   strDeque.offer(tmpStr.toString());
               }
           }else{
               strDeque.offer(str);
           }
        }

        while (!strDeque.isEmpty()){
            res.append(strDeque.pollFirst());
        }
        return res.toString();
    }

    public String decodeString1(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                while (Character.isDigit(s.charAt(i))){
                    num = num * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                i--;
            }else  if(ch == '['){
                numStack.push(num);
                strStack.push(res.toString());
                num = 0;
                res = new StringBuilder();
            }else if(Character.isLetter(ch)){
                res.append(ch);
            }else if(ch == ']'){
                StringBuilder tmp = new StringBuilder();
                int dup = numStack.pop();
                while (dup > 0){
                    tmp.append(res);
                    dup--;
                }
                res = new StringBuilder(strStack.pop() + tmp);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ProblemDecodeString().decodeString1("3[a2[cd]]"));
    }
}
