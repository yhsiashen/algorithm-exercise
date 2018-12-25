package org.yuhang.algorithm.leetcode.dynamicplan;

import java.util.ArrayList;
import java.util.List;

/**  单词拆分  139
 * Created by chinalife on 2018/10/13.
 */
public class ProblemWordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // n+1长度的boolean数组，存放长度为n的字符串是否匹配字典
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;
        for (int i = 1; i < s.length()+1 ; i++) {
            for (int j = 0; j < i; j++) {
                //判断长度为i的字符串是否匹配字典表
                if(result[j] && wordDict.contains(s.substring(j,i))){
                    result[i+1] = true;
                }
            }
        }
        return result[s.length()+1];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        new ProblemWordBreak().wordBreak(s,wordDict);
    }

}
