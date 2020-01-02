package org.yuhang.algorithm.leetcode.math;

/**
 * 字符串转换整数 LC8
 */
public class ProblemStringToIntegerAtoi {

    public int myAtoi(String str) {
        int positiveFlag = 1;
//        boolean isPositiveChar = false;
        int num = 0;
        String numStr = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                num += ch-'0';
                while (ch == '0' && i+1 < str.length() && str.charAt(i+1) == '0'){
                    i++;
                }
                int j = str.charAt(i) == '0'?i+1:i;
                while (i+1 < str.length() && Character.isDigit(str.charAt(i+1))){
                    num = num * 10 + (str.charAt(i+1)-'0');
                    i++;
                }
                numStr = str.substring(j,i+1);
                break;
            }else if(ch == '-' || ch == '+'){
                if(i+1<str.length() && !Character.isDigit(str.charAt(i+1))) return 0;
                positiveFlag = str.charAt(i) == '-'?-1:1;
            }else if(ch == ' '){
                continue;
            }else{
                return 0;
            }
        }
        //判断是否超过最大整数
        if(!"".equals(numStr)){
            if(numStr.length() > 10){
               return positiveFlag == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }else if(positiveFlag == 1 && numStr.length() == 10 && numStr.compareTo("2147483647") > 0){
                return Integer.MAX_VALUE;
            }else if(positiveFlag == -1 && numStr.length() == 10 && numStr.compareTo("2147483648") > 0){
                return Integer.MIN_VALUE;
            }
        }
        return num * positiveFlag;
    }

    public static void main(String[] args) {
//        System.out.println("214748362481".compareTo("2147483647"));
        System.out.println(new ProblemStringToIntegerAtoi().myAtoi("-0123123432"));
    }
}
