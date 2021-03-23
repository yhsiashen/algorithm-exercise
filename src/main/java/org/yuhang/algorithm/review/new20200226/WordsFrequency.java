package org.yuhang.algorithm.review.new20200226;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {


    Map<String,Integer> map;

    public WordsFrequency(String[] book) {
       map = new HashMap<>();
       for(String str:book){
           map.put(str, map.getOrDefault(str,0)+1);
       }
    }

    public int get(String word) {
       return  map.getOrDefault(word,0);
    }
}
