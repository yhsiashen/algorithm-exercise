package org.yuhang.algorithm.review;

import java.util.*;

/**
 * 字母异位词分组 LC49
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String ss = new String(chs);
            List<String> list = map.getOrDefault(ss,new ArrayList<>());
            list.add(str);
            map.put(ss,list);
        }

        List<List<String>> res = new ArrayList<>(map.values());
        return res;

    }
}
