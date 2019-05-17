package org.yuhang.algorithm.leetcode.tire;

/**
 * 字典设计-支持添加一个单词和查找一个单词存不存在 211 TODO
 */
public class WordDictionary {

    /**
     * a-z字符的trie实现,共26个字符
     */
    class TrieNode{
        char data;
        TrieNode[] children;
        boolean isEndingChar = false;
        public TrieNode(char data){
            this.data = data;
            children = new TrieNode[26];//用长度为26的数组表示26个字母的引用
        }
    }

    //根节点存储'/'
    private TrieNode root = new TrieNode('/');

    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word==null || word.length()==0) return;
        char[] chars = word.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < chars.length; i++) { //遍历每个字符，插入对应位置
            int index = chars[i] - 'a';
            if(p.children[index] == null ){
                p.children[index] = new TrieNode(chars[i]);
            }
            p = p.children[index]; //将p指向下一级
        }
        p.isEndingChar = true; //标记最后一个层级为结束标志

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
      if(word == null || word.length() == 0) return false;
      TrieNode p = root;
      return search0(word,p);
    }

    private boolean search0(String word,TrieNode p){
        if(word.length() == 0) return p.isEndingChar;
        if(word.charAt(0) != '.') {
            int index = word.charAt(0) - 'a';
            if(p.children[index].data != word.charAt(0))
                return false;
            return search0(word.substring(1),p.children[index]);
        }else{
            for (int i = 0; i < 26; i++) {
                return search0(word.substring(1),p.children[i]);
            }
        }
        return false;
    }
}
