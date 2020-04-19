package org.yuhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串 LC30
 */
public class ProblemSubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
          List<Integer> res = new ArrayList<>();
          if(s.length() == 0 || words.length == 0) return res;
          HashMap<String,Integer> wordMap = new HashMap<>();
          int totalNums = words.length;//单词总数
          int wordLength = words[0].length();//一个单词的长度
          for(String word:words){
              wordMap.put(word, wordMap.getOrDefault(word,0)+1);
          }


        for (int i = 0; i < s.length()-wordLength*totalNums+1; i++) {
            HashMap<String,Integer> windowMap = new HashMap<>();
            int windowNums = 0;
            while (windowNums < totalNums){//判断以i开始的字符串是否满足和words中单词相等
                String word = s.substring(i+windowNums*wordLength, i+(windowNums+1)*wordLength);
                if(wordMap.containsKey(word)){
                    windowMap.put(word, windowMap.getOrDefault(word,0)+1);
                    if(windowMap.get(word) > wordMap.get(word)) break;
                }else{
                    break;
                }
                windowNums++;
            }

            if(windowNums == totalNums){
                res.add(i);
            }
        }

          return res;
    }

    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0){
            return res;
        }
        int unit = words[0].length();
        int templLength = unit * words.length;
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for(String word : words){
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < unit; i++) {
            if ((s.length()-i) < words.length * unit) {
                continue;
            }
            int off = s.length()- i - templLength + 1;
            for (int j = 0; j < off; j+=unit) {
                HashMap<String, Integer> indexMap = new HashMap<>();
                for (int k = words.length-1 ;k>=0;k--){
                    String cut = s.substring(i+j+k*unit, i+j+(k+1)*unit);
                    int val = indexMap.getOrDefault(cut, 0) + 1;
                    if (val > wordsMap.getOrDefault(cut, 0)){
                        j = j+k*unit;
                        break;
                    }else {
                        indexMap.put(cut, val);
                    }
                    if (k == 0) {
                        res.add(j+i);
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"foo","bar","the"};
        System.out.println(new ProblemSubstringWithConcatenationOfAllWords().findSubstring1("barfoofoobarthefoobarman" ,words));
    }
}
