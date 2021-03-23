package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.List;

/**
 * 08.09 括号
 */
public class BracketLcci {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        backtrace(res, "",0,0, n);
        return res;
    }

    private void backtrace(List<String> res, String str, int left, int right, int n){
        if(str.length() == n << 1){
            res.add(str);
            return;
        }
        if(left < n){
            //选左括号
            backtrace(res,str+"(",left+1,right,n);
        }
        if(right < left){
            //选右括号
            backtrace(res,str+")", left,right+1,n);
        }

    }

    public static void main(String[] args) {
        System.out.println(new BracketLcci().generateParenthesis(3));
    }
}
