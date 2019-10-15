package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号所有可能的组成 LC22
 */
public class ProblemGenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrace(res,"",0,0,n);
        return res;
    }

    private void backtrace(List<String> res, String cur, int i, int j, int max) {
        if(cur.length() == max<<1){
            res.add(cur);
            return;
        }

        if(i < max){ // i表示'('的安排数量，最多可以安排max个，当i比max小时即可安排
            backtrace(res,cur+"(",i+1,j,max);
        }

        if(j < i){ // j表示')'的安排数量，最多也可以安排max个，当j比i小时即可安排，即安排'('时得先安排')'
            backtrace(res,cur+")",i,j+1,max);
        }

    }
}
