package org.yuhang.algorithm.leetcode.tire;

/**
 * 字典设计-支持添加一个单词和查找一个单词存不存在 211
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
      return search0(word,p,0);
    }

    /**
     * DFS,i代表层,即word的位置
     * @param word
     * @param p
     * @param i
     * @return
     */
    private boolean search0(String word,TrieNode p,int i){
        if(i == word.length()) return p.isEndingChar;//要查找的字符串结束，根据trie树是否结束返回结果
        if(word.charAt(i) != '.') {
            int index = word.charAt(i) - 'a';
            return p.children[index]!=null && p.children[index].data == word.charAt(i)
                    && search0(word,p.children[index],i+1);
        }else{
            for (TrieNode node:p.children) { //若char为'.',则遍历p的每个不为空的子树,有一个true则结果为true
                if(node !=null && search0(word,node,i+1)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         * ["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
         * [[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
         */
        WordDictionary wd = new WordDictionary();
        wd.addWord("at");
        wd.addWord("and");
        wd.addWord("an");
        wd.addWord("add");
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".at"));
        wd.addWord("bat");
        System.out.println(wd.search(".at"));
    }

}
