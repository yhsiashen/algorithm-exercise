package org.yuhang.algorithm.leetcode.backtracealgo;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 判断一个字符串是不是累加数 LC306
 */
public class ProblemAdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        return backtrace(num,new BigDecimal(-1),new BigDecimal(-1),0);
    }
    //"19910011992"
    private boolean backtrace(String num,  BigDecimal pre1, BigDecimal pre2, int calnum){
        if("".equals(num) && calnum >0) return true;
        BigDecimal subStr;
        for (int i = 0; i < num.length(); i++) {
//            try {
//                subStr = Long.parseLong(num.substring(0, i + 1));//注意整数溢出问题?
//            }catch (Exception e){
//                System.out.println("溢出了！字符串为:"+num.substring(0,i+1));
//                return false;
//            }
//            subStr = subStr*10+num.charAt(i) - '0';
            subStr = new BigDecimal(num.substring(0,i+1));
            if(pre1.equals(new BigDecimal(-1))){
                if(backtrace(num.substring(i+1), subStr, pre2,calnum)){
                    return true;
                }
            }else if(pre2.equals(new BigDecimal(-1))){
                if(backtrace(num.substring(i+1), pre1,subStr,calnum)){
                    return true;
                }
            }else{
                if(pre1.add(pre2).equals( subStr)) {
                    if (backtrace(num.substring(i + 1), pre2, subStr, calnum + 1)) {
                        return true;
                    }
                }
//                }else if(pre1+pre2 < subStr){//剪枝
//                    break;
//                }
            }
            if(i==0 && num.charAt(0) == '0') break;//当首字母为0时，只允许取0充当一个数，后续的不再判断
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new ProblemAdditiveNumber().isAdditiveNumber(
//                "11235813213455890144"));
        BigDecimal i = new BigDecimal("1.23");
        BigDecimal j = new BigDecimal("2031");
        System.out.println(i.add(j).toString());
        System.out.println(i.add(j).floatValue());

    }


}
