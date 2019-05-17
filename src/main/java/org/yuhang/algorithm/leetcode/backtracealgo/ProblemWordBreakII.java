package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.*;

/**
 * 单词拆分2  140
 */
public class ProblemWordBreakII {


    /**
     * 回溯
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> hashmap = new HashMap<>();  //字符串和可组单词的映射,做缓存
        return helper(s, wordDict, hashmap);
    }

    /**
     * @param s
     * @param wordDict
     * @param hashmap
     * @return
     */
    private List<String> helper(String s, List<String> wordDict, Map<String, List<String>> hashmap) {
        if (hashmap.containsKey(s)) return hashmap.get(s);
        if (s.length() == 0) return null;

        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            int wordlength = word.length();
            if (s.length()>=wordlength && s.substring(0, wordlength).equals(word)) { //先找到字符串中的头部单词且在字典中存在的
                List<String> list = helper(s.substring(wordlength), wordDict, hashmap);//得到后面子字符串的list
                if(list!=null) {
                    for (String wordres : list) { //将word 以及 list中的每个word拼接成一句话
                        res.add(word + " " + wordres);
                    }
                }else{
                    res.add(word);
                }

            }
        }
        hashmap.put(s,res);//缓存
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        new ProblemWordBreakII().wordBreak(s,list);
    }
}
