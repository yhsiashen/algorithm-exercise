package org.yuhang.algorithm.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数 LC166
 */
public class ProblemFractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        StringBuilder res = new StringBuilder();
        if(numerator <0 ^ denominator < 0){//有一个为负，另一个不为负，则加负号
            res.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));//除数
        long divisor = Math.abs(Long.valueOf(denominator));//被除数
        res.append(dividend / divisor);
        long remainder = dividend % divisor; //余数
        if(remainder == 0) return res.toString();
        res.append(".");
        Map<Long,Integer> map = new HashMap<>();
        while (remainder!=0){
            if(map.containsKey(remainder)){//当余数发现重复时，说明小数有循环，则用()后返回结果
                res.insert(map.get(remainder), "(");
                res.append(")");
                break;
            }
            map.put(remainder, res.length());//将余数与此时字符串的长度对应关系存入hash表
            remainder *= 10;//结果为小数时，余数*10继续除除数
            res.append(remainder/divisor);
            remainder %= divisor;
        }

       return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(new ProblemFractionToRecurringDecimal().fractionToDecimal(1,333));
        long a = (long) Integer.MIN_VALUE;
        long b = (long) -1;
        System.out.println(2 % 3);
    }
}
