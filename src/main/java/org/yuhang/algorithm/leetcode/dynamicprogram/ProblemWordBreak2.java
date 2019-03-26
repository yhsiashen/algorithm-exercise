package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词拆分2  140  //TODO
 */
public class ProblemWordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        //所有可能结果
        List<String> result = new ArrayList<>();
        String[] dp = new String[s.length()+1];
        dp[0] = "";
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                //判断长度为i的字符串是否匹配字典表
                if(dp[j]!=null && wordDict.contains(s.substring(j,i))){
                    dp[i+1] = s.substring(j,i);
                }
            }
        }


        return null;

    }
}
