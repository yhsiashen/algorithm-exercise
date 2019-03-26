package org.yuhang.algorithm.leetcode.string;


/**
 * 翻转字符串中的单词，并去除多余空格
 * e.g Input: "the sky is blue"     Input: "  hello world!  "
 *     Output: "blue is sky the"    Output: "world! hello"
 *
 */
public class ProblemReserveWords {


    public String reverseWords(String s) {
        if(s==null)
          return null;
        String[] ss = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = ss.length-1; i >=0 ; i--) {
            if(!"".equals(ss[i])) {
                result.append(ss[i].trim());
                result.append(" ");
            }
        }
        return result.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(new ProblemReserveWords().reverseWords(" hello  world! "));
    }

}
