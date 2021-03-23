package org.yuhang.algorithm.review.new20200226;

import java.util.*;

/**
 * 10.02 变位词组
 */
public class GroupAnagramsLcci {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) return res;
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String s = new String(chs);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s,list);
        }

        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        new GroupAnagramsLcci().groupAnagrams(strs);
    }
}
