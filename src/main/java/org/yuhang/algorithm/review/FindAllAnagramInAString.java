package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中的所有字母异位词 LC438
 */
public class FindAllAnagramInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;
        int[] p_map = new int[26];
        int p_length  = p.length();
        for (int i = 0; i < p_length; i++) {
            p_map[p.charAt(i)-'a']++;
        }
        int[] s_map = new int[26];
        int match = 0;
        int l=0,r=0;
        while (r<s.length()){
            int chIdx = s.charAt(r) -'a';
            s_map[chIdx]++;
            if(s_map[chIdx] <= p_map[chIdx]){
                match++;
            }

            while (match == p_length){//窗口中包含了p字符串的全部字符
                if(r-l+1 == p_length) res.add(l);
                int reIdx  = s.charAt(l) -'a';
                if(s_map[reIdx] <= p_map[reIdx]){
                    match--;
                }
                s_map[reIdx]--;//移除l位置的字符计数
                l++;
            }

            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        new FindAllAnagramInAString().findAnagrams("cbaebabacd","abc");

    }
}
