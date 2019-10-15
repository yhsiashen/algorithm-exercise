package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合 17
 */
public class ProblemLetterCombinationsOfPhoneNumber {

    final static Map<String,String> phone = new HashMap<>();

    static {
        phone.put("2","abc");
        phone.put("3","def");
        phone.put("4","ghi");
        phone.put("5","jkl");
        phone.put("6","mno");
        phone.put("7","pqrs");
        phone.put("8","tuv");
        phone.put("9","xwyz");
    }

    List<String> output = new ArrayList<>();

    private void backtrack(String combination, String next_digits){
        if(next_digits.length() == 0){ //到达边界,保存结果
            output.add(combination);
        }else{
            String digit = next_digits.substring(0,1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i,i+1);
                backtrack(letter+combination,next_digits.substring(1));
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()!=0){
            backtrack("",digits);
        }
        return output;
    }

    public static void main(String[] args) {
          new ProblemLetterCombinationsOfPhoneNumber().letterCombinations("346");
    }
}
