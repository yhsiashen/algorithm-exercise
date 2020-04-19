package org.yuhang.algorithm.leetcode.design;

/**
 * Trie树的实现
 */
public class Trie {

    class TrieNode{
        char val;
        TrieNode[] children;
        boolean isEndChar;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isEndChar = false;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('/');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        int j = 0;
        while (j < word.length()){
            char ch = word.charAt(j);
            if(cur.children[ch-'a']==null){
               cur.children[ch-'a'] = new TrieNode(ch);
            }
            cur = cur.children[ch-'a'];
            j++;
        }
        cur.isEndChar = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        int j = 0;
        while (j < word.length()){
            char ch = word.charAt(j);
            if(cur.children[ch-'a'] == null){
                return false;
            }
            cur = cur.children[ch-'a'];
            j++;
        }
        return cur.isEndChar;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        int j = 0;
        while (j < prefix.length()){
            char ch = prefix.charAt(j);
            if(cur.children[ch-'a'] == null){
                return false;
            }
            cur = cur.children[ch-'a'];
            j++;
        }

        return true;
    }
}
