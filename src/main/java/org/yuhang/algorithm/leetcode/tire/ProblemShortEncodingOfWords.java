package org.yuhang.algorithm.leetcode.tire;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 单词的压缩编码 LC820
 * @Trie树
 */
public class ProblemShortEncodingOfWords {

    /**
     * 字符串逆序法
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        if(words.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        Arrays.sort(words);//按字典序排序
        for (int i = 0; i < words.length; i++) {
           while (i<words.length-1 && words[i+1].indexOf(words[i]) == 0){
               i++;
           }
           res += words[i].length()+1;
        }
        return res;
    }


    private String reverse(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length()-1; i >=0 ; i--) {
            sb.append(word.charAt(i));
        }
        return sb.toString();

    }

    //Tire树定义
    class Trie{

        //定义一个小写字符单词的tire节点
        class TrieNode{
            char val;
            TrieNode[] children = new TrieNode[26];
            public TrieNode(){}
            public TrieNode(char val){
                this.val = val;
            }

        }

        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        //Trie树中插入一个单词并返回新增的编码长度
        public int insert(String word){
            TrieNode cur = root;
            boolean isNew = false;//表示插入的单词是否是新单词
            //单词倒着插入
            for (int i = word.length()-1; i >=0 ; i--) {
                int c = word.charAt(i) - 'a';
                if(cur.children[c] == null){
                    isNew = true;//表示插入的word是新单词
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            return isNew?word.length()+1:0;
        }
    }

    /**
     * tire树法
     * @param words
     * @return
     */
    public int minimumLengthEncoding1(String[] words) {
         Trie wordTrie = new Trie();
         Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
         int  res = 0;
         for(String word:words) res += wordTrie.insert(word);
         return res;
    }

    public static void main(String[] args) {
        String[] words = {"time", "atime", "btime"};
        System.out.println(new ProblemShortEncodingOfWords().minimumLengthEncoding1(words));

    }

}
