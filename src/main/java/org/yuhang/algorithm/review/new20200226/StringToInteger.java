package org.yuhang.algorithm.review.new20200226;

/**
 * 字符串转整数
 */
public class StringToInteger {

    public int myAtoi(String s) {
       if(s.length() == 0) return 0;
       s = s.trim(); //去除空格
       int symbol = 1; //表示符号
       int num = 0;
       for (int i = 0; i <s.length();) {
           char ch = s.charAt(i);
           if (i == 0 && (ch == '+' || ch == '-')) {//判断首字符是否为正负符号
               symbol = ch == '+'?1:-1;
           }else if(Character.isDigit(ch)){//遍历数字直到遇到第一个非数字或字符串结尾则停止,需考虑数字是否越界
               long lnum = 0;
               while (i < s.length() && Character.isDigit(s.charAt(i))){
                   lnum = lnum * 10 + s.charAt(i) - '0';
                   i++;
                   if(symbol == 1 && lnum > Integer.MAX_VALUE){
                       return Integer.MAX_VALUE;

                   }else if(symbol == -1 && -lnum < Integer.MIN_VALUE){
                       return Integer.MIN_VALUE;
                   }
               }
               num = lnum == 0? 0 : (int)(lnum * symbol);
               return num;
           }else{//遍历到非数字则停止
               break;
           }
           i++;
       }
       return num;
    }

    public static void main(String[] args) {
        String s= "   -42";
        System.out.println(new StringToInteger().myAtoi(s));
    }
}
