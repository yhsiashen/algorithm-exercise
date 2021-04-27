package org.yuhang.algorithm.review.new20200226;

/**
 * 翻转字符串里的单词
 * 输入："  hello world!  "
 * 输出："world! hello"
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >=0; i--) {
            if(!"".equals(strs[i])) sb.append(strs[i]).append(" ");
        }

        return sb.substring(0,sb.length()-1);
    }



    public static void main(String[] args) {
        System.out.println(new ReverseWordsInString().reverseWords("a good   example"));
    }
}
