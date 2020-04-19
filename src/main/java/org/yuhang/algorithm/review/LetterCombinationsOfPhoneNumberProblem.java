package org.yuhang.algorithm.review;

import java.util.*;

/**
 * 电话号码的字母组合 LC17
 */
public class LetterCombinationsOfPhoneNumberProblem {

    public List<String> letterCombinations(String digits) {
         List<String> res = new ArrayList<>();
         if(digits.length() == 0) return res;
         Map<Character,String> map = new HashMap<>();
         map.put('2',"abc");
         map.put('3',"def");
         map.put('4',"ghi");
         map.put('5',"jkl");
         map.put('6',"mno");
         map.put('7',"pqrs");
         map.put('8',"tuv");
         map.put('9',"wxyz");
         dfs(digits,map,res,"");
         return res;
    }

    private void dfs(String digits, Map<Character, String> map, List<String> res,String pre) {
        if("".equals(digits)){
            res.add(pre);
            return;
        }
        char num = digits.charAt(0);
        String chrs = map.get(num);
        for (int i = 0; i < chrs.length(); i++) {
            dfs(digits.substring(1),map,res,pre+chrs.charAt(i));
        }
    }
}
