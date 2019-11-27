package org.yuhang.algorithm.leetcode.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 判断两字符串代表的单词是否是有效的字母异位词 LC242
 * @tag:哈希表
 */
public class ProblemValidAnagram {


    /**
     * 普通方法,遍历s的每个字符,判断其在t中是否存在
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        while (!"".equals(s) && !"".equals(t) && s.length()==t.length()){
            String str = s.substring(0,1);
            if(!t.contains(str)){
                return false;
            }else {
                s = s.replaceAll(str,"");
                t = t.replaceAll(str,"");
            }
        }

        if(s.length()!=t.length()) return false;
        return "".equals(s) && "".equals(t);
    }


    /**
     * 哈希表,为26个单词建立哈希表
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),(map.get(s.charAt(i))+1));
            }

            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),-1);
            }else{
                map.put(t.charAt(i),(map.get(t.charAt(i))-1));
            }
        }

        for (int i : map.values()){
            if(i!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * 哈希表，因为字符串中只有英文小写字母，则只需26位的int数组做哈希表，能极大简化代码，降低时间复杂度
     * 若字符串中包含ASCII码的所有内容,则用一个128位的数组做哈希表
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] alpha = new int[128];
        for(int i = 0; i< s.length(); i++) {
            alpha[s.charAt(i)] ++;
            alpha[t.charAt(i)] --;
        }
        for(int i=0;i<128;i++)
            if(alpha[i] != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemValidAnagram().isAnagram3(".;'asnasj",".,:a'nasj"));
    }


}
