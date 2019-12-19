package org.yuhang.algorithm.leetcode.math;

import java.util.Collections;

/**
 * Excel表序列号 LC171
 */
public class ProblemExcelsheetcolumnnumber {

    public int titleToNumber(String s) {
        if(s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int res=0;
        for (int i = chs.length-1; i >=0 ; i--) {
            int carry = chs.length - i;//表示目前字符代表的进位
            res += (chs[i] - 'A' + 1) * Math.pow(26,carry-1);
        }
        return res;
    }
}
