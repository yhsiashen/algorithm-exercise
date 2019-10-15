package org.yuhang.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串的Z字型变换  6
 */
public class ProblemZigzagConversion {

    public String convert(String s, int numRows) {
        if(s.isEmpty() || numRows <= 1) return s; //s为空字符串或返回行数为1以下时，直接返回
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(i,new StringBuilder());
        }
        int curRow = 0; //当前的行数
        boolean goDown = false; //前进方向

        for(char c: s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1) {
              goDown = !goDown; //当遇到第一行或最后一行时，反向前进
            }
            curRow += goDown?1:-1; //根据前进方向决定
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : rows) result.append(sb);
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "LEET";
        System.out.println(new ProblemZigzagConversion().convert(s,5));
    }


}
