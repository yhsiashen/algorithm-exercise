package org.yuhang.algorithm.review;

/**
 * 字符串转换整数 LC8
 */
public class StringToIntegerAtoiProblem {

    public int myAtoi(String str) {
        int ans = 0;
        str = str.trim();
        if(str.length() == 0) return 0;
        if(!Character.isDigit(str.charAt(0)) && str.charAt(0) != '-' && str.charAt(0) !='+'){
            return 0;
        }
        int positive = 1;//正负数标记
        if(str.charAt(0) == '-') {
            positive = -1;
            str = str.substring(1);
        }else if(str.charAt(0) == '+'){
            str = str.substring(1);
        }

        if(str.length()==0 || !Character.isDigit(str.charAt(0))) return 0;
        int i = 0;
        ans = str.charAt(i)-'0';
        while (i+1<str.length() && Character.isDigit(str.charAt(i+1))){
                int num = str.charAt(i+1)-'0';
                if(ans > (Integer.MAX_VALUE - num)/10){ //避免整数溢出，或者也可以将要比较的数都转换成long再比较
                    return positive==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                ans = ans*10+num;
                i++;
        }

        return ans*positive;

    }
}
