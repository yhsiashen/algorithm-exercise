package org.yuhang.algorithm.review;

import java.util.Stack;

/**
 * 字符串解码 LC394
 */
public class DecodeString {



    public String decodeString(String s) {
        Stack<Integer> freqs = new Stack<>();
        Stack<String> str = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
            }else if(ch == '['){
                freqs.push(num);
                str.push(res.toString());
                num = 0;
                res = new StringBuilder();

            }else if(ch == ']'){
                StringBuilder tmp = new StringBuilder();
                int dup = freqs.pop();
                while (dup > 0){
                    tmp.append(res);
                    dup--;
                }
                res = new StringBuilder(str.pop()+tmp);
            }else{
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[b4[F]c]"));
    }
}
