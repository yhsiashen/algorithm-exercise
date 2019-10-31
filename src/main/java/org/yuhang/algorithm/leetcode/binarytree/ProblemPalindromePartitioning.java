package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串 LC131
 *
 */
public class ProblemPalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrace(res,s,new ArrayList<>());
        return res;
    }

    private void backtrace(List<List<String>> res,String s,List<String> list){
        if("".equals(s)){//s遍历结束，将list加入res中
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            if(check(s.substring(0,i))){//若子串是回文串
                list.add(s.substring(0,i));
                backtrace(res,s.substring(i),list);
                list.remove(list.size()-1);//回溯
            }
        }
    }

    private boolean check(String s){
          int i = 0;
          int j = s.length()-1;
          while (i < j){
              if(s.charAt(i)!= s.charAt(j)) return false;
              i++;
              j--;
          }
          return true;
    }

    public static void main(String[] args) {
        new ProblemPalindromePartitioning().partition("aab");
    }
}
