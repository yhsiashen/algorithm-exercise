package org.yuhang.algorithm.leetcode.tire;

/**
 * Trie树的实现 208
 */
public class Trie {

    /**
     * a-z字符的trie实现,共26个字符
     */
    class TrieNode{
        char data;
        TrieNode[] children;
        boolean isEndingChar = false;
        public TrieNode(char data){
            this.data = data;
            children = new TrieNode[26];
        }
    }

    //根节点存储'/'
    private TrieNode root = new TrieNode('/');

    public Trie(){}

    /**
     * 插入字符串到trie树中
     * @param word
     */
    public void insert(String word){
        if(word == null || word.length() ==0)
            return;
        TrieNode p = root;
        //遍历每个字符,将最后一个节点的isEndingChar标识为true
        for (int i = 0; i < word.length(); i++) {
            //计算要插入字符的索引位置
            int index = word.charAt(i) - 'a';
            //判断该位置是否有值,无值则插入
             if(p.children[index] == null)
                 p.children[index] = new TrieNode(word.charAt(i));
             p = p.children[index];
        }
        p.isEndingChar = true;
    }

    /**
     * 在trie树中查找某字符串是否存在
     * @param word
     * @return
     */
    public boolean search(String word){
       if(word == null || word.length() ==0)
           return false;
       TrieNode p = root;
       //从trie树的根节点开始找,直到找到完全匹配的整个字符串则返回true
        for (int i = 0; i < word.length() ; i++) {
             int index = word.charAt(i) - 'a';
             if(p.children[index]!=null) {
                 p = p.children[index];
             }else {
                 return false;
             }
        }
        //查找的字符串遍历完毕,判断此时的trie节点是否结束,
        //若没有结束,则表明输入的字符串是trie树中某字符串的前缀
        return p.isEndingChar;
    }


    /**
     * 判断字符串是否是trie树中某字典的前缀
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() ==0)
            return false;
        TrieNode p = root;
        for (int i = 0; i < prefix.length() ; i++) {
            int index = prefix.charAt(i) - 'a';
            if(p.children[index]!=null) {
                p = p.children[index];
            }else {
                return false;
            }
        }
        return true;
    }


}
