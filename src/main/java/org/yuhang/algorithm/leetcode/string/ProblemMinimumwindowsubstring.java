package org.yuhang.algorithm.leetcode.string;


import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖字串 LC76
 * @tag:滑动窗口
 */
public class ProblemMinimumwindowsubstring {

    public String minWindow(String s, String t) {
        if("".equals(s)) return "";
        Map<Character,Integer> windowMap = new HashMap<>();
        Map<Character,Integer> needsMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            needsMap.put(t.charAt(i),needsMap.getOrDefault(t.charAt(i),0)+1);
        }
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int left = 0,right = 0, match = 0;
        while (right < s.length()){
            char ch1 = s.charAt(right);
            if(needsMap.containsKey(ch1)){
                windowMap.put(ch1,windowMap.getOrDefault(ch1,0)+1);
                if(windowMap.get(ch1).equals(needsMap.get(ch1))){
                    match++;
                }
            }
            //windowMap中包含t中字符的key已符合要求,移动左指针,直到窗口不符合要求
            while (match == needsMap.size()){
                if(minLength > right-left+1){
                    start = left;
                    minLength = right-left+1;
                }
                char ch2 = s.charAt(left);
                if(needsMap.containsKey(ch2)){
                    windowMap.put(ch2,windowMap.get(ch2)-1);
                    if(windowMap.get(ch2) < needsMap.get(ch2)){
                        match--;
                    }
                }
                left++;
            }
            right++;
        }

        return minLength==Integer.MAX_VALUE?"":s.substring(start,start+minLength);
    }
}
