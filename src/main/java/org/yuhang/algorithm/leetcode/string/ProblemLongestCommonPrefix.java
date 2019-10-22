package org.yuhang.algorithm.leetcode.string;

/**
 * 最长公共前缀 LC14
 */
public class ProblemLongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String curPre = strs[0]; //初始前缀
        for(String str:strs){
            while (str.indexOf(curPre) != 0){//判断字符串是不是以curPre为前缀的
                curPre = curPre.substring(0,curPre.length()-1);
                if("".equals(curPre)) return ""; //前缀为空的时候返回
            }
        }
        return curPre;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new ProblemLongestCommonPrefix().longestCommonPrefix(strs));

    }
}
