package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * T9键盘
 *
 *输入: num = "8733", words = ["tree", "used"]
 *输出: ["tree", "used"]
 *
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 *
 *
 */
public class T9Lcci {

    public List<String> getValidT9Words(String num, String[] words) {
        Map<String,String> map = new HashMap<>();
        putNumInMap(map);
        List<String> matched = new ArrayList<>();
        for(String word:words){
            if(isMatched(num, word, map)){
                matched.add(word);
            }
        }
        return matched;
    }

    private void putNumInMap(Map<String, String> map) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    private boolean isMatched(String num, String word, Map<String,String> map){
        for (int i = 0; i < num.length(); i++) {
              String n = num.substring(i,i+1);
              String chars = map.get(n);
              if(!chars.contains(word.substring(i,i+1))){
                  return false;
              }
        }
        return true;
    }
}
