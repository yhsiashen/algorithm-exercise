package org.yuhang.algorithm.leetcode.string;

import org.yuhang.algorithm.leetcode.array.Array;

import java.util.*;

/**
 * 字母异位词分组 LC49
 */
public class ProblemGroupanagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) return res;
        Map<String,List<String>> map = new HashMap<>();
        for (String str:strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            List<String> tmp = map.getOrDefault(key,new ArrayList<>());
            tmp.add(str);
            map.put(key,tmp);
        }
        res.addAll(map.values());

        return res;
    }
}
