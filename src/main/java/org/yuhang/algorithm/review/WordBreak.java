package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词拆分 LC139
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if("".equals(s)){//s中的单词已拆分完毕
            return true;
        }
        for (int i = 1; i < s.length()+1; i++) {
            String word = s.substring(0,i);
            if(wordDict.contains(word) && wordBreak(s.substring(i),wordDict)){
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];//dp[i]表示s.substr(0,i)是否能被拆分
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                String word = s.substring(j,i);
                if(dp[j] && wordDict.contains(word)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aaa");
//        list.add("dog");
        System.out.println(new WordBreak().wordBreak1("aaaaaaa",list));
    }

}
