package org.yuhang.algorithm.leetcode.backtracealgo;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 判断一个字符串是不是累加数 LC306
 */
public class ProblemAdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        for (int i = 1; i < num.length() + 1; i++) {
            BigDecimal a = new BigDecimal(num.substring(0, i));
            BigDecimal b = new BigDecimal("0");
            if (i<num.length() && num.charAt(i) == '0') {//当前头元素为0，单独考虑
                int k = i + 2;
                while (k < num.length() + 1) {
                    BigDecimal c = new BigDecimal(num.substring(i + 1, k));
                    if (a.equals(c)) {
                        if (k == num.length()) return true;
                        return backtrace(num.substring(i), 1, k - i);
                    }
                    k++;
                }
            } else {
                for (int j = i + 1; j < num.length() + 1; j++) {
                    b = new BigDecimal(num.substring(i, j));
                    int k = j + 1;
                    while (k < num.length() + 1) {
                        BigDecimal c = new BigDecimal(num.substring(j, k));
                        if ((a.add(b)).equals(c)) {
                            if (k == num.length()) return true;
                            return backtrace(num.substring(i), j - i, k - i);
                        }
                        k++;
                    }
                }
            }
        }
            return false;

    }

    private boolean backtrace(String num,int j,int k){
        BigDecimal a = new BigDecimal(num.substring(0,j));
        BigDecimal b = new BigDecimal(num.substring(j,k));
        int l = k+1;
        while (l<num.length()+1){
            BigDecimal c = new BigDecimal(num.substring(k,l));
            if((a.add(b)).equals(c)){
                if(l==num.length()) return true;
                return backtrace(num.substring(j),k-j,l-j);
            }
            l++;
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new ProblemAdditiveNumber().isAdditiveNumber("101"));
        BigInteger big = new BigInteger("1231242345435490231435");
        System.out.println(big.add(new BigInteger("23423422")).toString(2));
    }


}
