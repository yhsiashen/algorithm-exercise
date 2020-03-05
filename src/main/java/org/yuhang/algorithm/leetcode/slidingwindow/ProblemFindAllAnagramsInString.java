package org.yuhang.algorithm.leetcode.slidingwindow;


import java.util.*;

/**
 * 找到字符串中所有字母异位词 LC438
 * @tag:滑动窗口
 */
public class ProblemFindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if("".equals(s)) return res;
        Map<Character,Integer> windowMap = new HashMap<>();
        Map<Character,Integer> needsMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            needsMap.put(p.charAt(i),needsMap.getOrDefault(p.charAt(i),0)+1);
        }
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
                if(right-left+1 == p.length()) res.add(left);
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

        return res;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if("".equals(s)) return res;
        int[] windowMap = new int[26];
        int[] needsMap = new int[26];
        int pl=0;
        for (int i = 0; i < p.length(); i++) {
            needsMap[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < needsMap.length ; i++) {
            if(needsMap[i] > 0)pl++;
        }
        int left = 0,right = 0, match = 0;
        while (right < s.length()){
            char ch1 = s.charAt(right);
            if(needsMap[ch1-'a'] > 0){
                windowMap[ch1-'a']++;
                if(windowMap[ch1-'a']==needsMap[ch1-'a']){
                    match++;
                }
            }
            //windowMap中包含t中字符的key已符合要求,移动左指针,直到窗口不符合要求
            while (match == pl){
                if(right-left+1 == p.length()) res.add(left);
                char ch2 = s.charAt(left);
                if(needsMap[ch2-'a']>0){
                    windowMap[ch2-'a']--;
                    if(windowMap[ch2-'a'] < needsMap[ch2-'a']){
                        match--;
                    }
                }
                left++;
            }
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemFindAllAnagramsInString().findAnagrams1("cbaebabacd","abc"));
    }

}
