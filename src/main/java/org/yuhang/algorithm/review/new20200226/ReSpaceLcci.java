package org.yuhang.algorithm.review.new20200226;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符
 *
 *  0 <= len(sentence) <= 1000
 *  dictionary中总字符数不超过 150000。
 *  你可以认为dictionary和sentence中只包含小写字母。
 *
 */
public class ReSpaceLcci {

    /**
     * 动态规划
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        if(sentence.length() == 0) return 0;
        int slen = sentence.length();
        HashSet<String> set  = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[slen+1];//dp[i]代表sentence前i个字符的最少未识别数,dp[slen]代表前slen
        dp[0] = 0;
        for (int i = 1; i < slen+1 ; i++) {
            dp[i] = dp[i-1]+1;
            for (int idx = 0; idx < i; idx++) {
                if(set.contains(sentence.substring(idx, i))){
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }
        return dp[slen];
    }

    /**
     * 动态规划+trie树
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace1(String[] dictionary, String sentence) {
        int slen = sentence.length();
        if(slen == 0) return 0;
        //构造trie树，将dic中的单词逆序插入trie中
        root = new Trie('/');
        for(String word:dictionary){
            StringBuilder w = new StringBuilder(word);
            word = w.reverse().toString();
            insert(word);
        }

        int[] dp = new int[slen+1];//dp[i]代表sentence前i个字符的最少未识别数,dp[slen]代表整个字符串
        dp[0] = 0;
        for (int i = 1; i < slen+1 ; i++) {
            dp[i] = dp[i-1]+1;
            //查找以i开头的字符串是否在字典中
            String str  = new StringBuilder(sentence.substring(0,i)).reverse().toString();
            int idx = isExits(str);
            if(idx!=-1){
                dp[i] = Math.min(dp[i], dp[str.length()-idx-1]);
            }
        }
        return dp[slen];

    }



    /**
     * trie节点的定义
     */
    class Trie{
        char data;//trie节点的数据
        Trie[] children;//子孩子
        boolean isEndingChar;//该节点是否为trie数的叶子节点
        public Trie(char data){
            this.data = data;
            this.children = new Trie[26];//26个小写字母
        }
    }

    private Trie root;//根节点,data为'/'

    private void insert(String word){
        if(word == null || word.length() == 0) return;
        Trie p = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';//i处字符的索引
            if(p.children[idx] == null){//若为空，则在该处新增一个trie节点
                p.children[idx] = new Trie(word.charAt(i));
            }
            p = p.children[idx];
        }
        p.isEndingChar = true;
    }

    /**
     * 判断word的任意前缀或word是否在trie树里
     * 当遍历word到任一字符时，若此时的trie为叶子节点，则判定word的这部分前缀在trie里
     * 若word遍历完后，此时刚好到叶子节点，则这个word在trie里
     * @param word
     * @return
     */
    private int isExits(String word) {
        Trie p = root;
        int res = -1;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';//i处字符的索引
            if (p.children[idx] == null) {
                return res;
            } else {
                p = p.children[idx];
                if (p.isEndingChar) {
                    res = i;
                }
            }
        }
        res = p.isEndingChar? word.length()-1:res;
        return res;
    }


    public static void main(String[] args) {
        String[] dictionary = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(new ReSpaceLcci().respace1(dictionary,sentence));

    }



}
