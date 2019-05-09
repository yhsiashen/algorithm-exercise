package org.yuhang.algorithm.leetcode.bitmanu;

/**
 * 最大单词长度乘积 318 位操作
 */
public class ProblemMaxProductOfWordLengths {

    public int maxProduct(String[] words) {
        if(words == null || words.length == 0) return 0;
        int[] mask = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) { //遍历每个字符串，将每个字符转化为int的位数
                mask[i] |= 1 << (words[i].charAt(j) - 'a'); // 将1左移 'char'-'a'位即得到该字符在32位int型数中所处的位置
                                                            // 后面的每一位字符与前面的结果做或运算，最后得到一个字符串对应的整数
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                int flag = mask[i] & mask[j]; // 两数想与判断是否含有相同元素，等于0表示不含相同元素
                if(flag == 0 && words[i].length()*words[j].length() > max){
                    max = words[i].length()*words[j].length();
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String[] words = {"a","aa","aaa","aaaa"};
        new ProblemMaxProductOfWordLengths().maxProduct(words);
    }
}
