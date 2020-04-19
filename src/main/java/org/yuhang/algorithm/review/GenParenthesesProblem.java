package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成 LC22
 */
public class GenParenthesesProblem {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        backtrace(res,0,0,n,"");
        return res;
    }

    private void backtrace(List<String> res, int left,int right,int n,String parenthesis) {
        if(left+right == 2*n){
            res.add(parenthesis);
            return;
        }

        if(left <= n) {
            backtrace(res, left+1,right ,n, parenthesis+"(");
        }
        if(right < left){
            backtrace(res,left,right+1,n,parenthesis+")");
        }
    }
}
