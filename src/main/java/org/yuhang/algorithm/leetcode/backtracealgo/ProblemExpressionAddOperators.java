package org.yuhang.algorithm.leetcode.backtracealgo;

import java.util.ArrayList;
import java.util.List;

/**
 * 给表达式加运算符 LC282
 * TODO
 */
public class ProblemExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if("".equals(num)) return res;
        backtrace(num,target,res);
        return res;
    }

    private void backtrace(String num, int target, List<String> res) {


    }
}
