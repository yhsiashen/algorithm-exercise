package org.yuhang.algorithm.review;

import java.util.regex.Pattern;

/**
 * 正则表达式匹配 LC10
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {


       return false;
    }

    public static void main(String[] args) {
        String pattern = "^[A-Z0-9]*(_[A-Z][0-9])*$";
        boolean isMatch = Pattern.matches(pattern,"AA0");
        System.out.println(isMatch);
    }
}
