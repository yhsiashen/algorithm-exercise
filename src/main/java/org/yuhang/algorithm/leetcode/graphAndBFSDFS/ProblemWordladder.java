package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.*;

/**
 * 单词接龙，给定两单词，找到转化的最短路径长度 127
 */
public class ProblemWordladder {

    /**
     * BFS，在字典中一个个找符合要求的转换单词，找到最短的即可返回
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       int level = 0;
       Queue<String> queue = new ArrayDeque<>();
       Set<String> set = new HashSet<>(wordList); //用hashset存单词词典，后面检索的时候快
       queue.offer(beginWord);
       while (!queue.isEmpty()){
           int size = queue.size();
           for (int i = 0; i < size; i++) { //将该level层的所有元素依次取出，匹配下一个单词
               String first = queue.poll();
               if(first.equals(endWord)) return ++level;
               for (int j = 0; j < first.length(); j++) { //遍历first字符串的每个元素
                   char[] array = first.toCharArray();
                   for (char k = 'a'; k <= 'z'; k++) {
                       array[j] = k; //将j位换成char k
                       String newStr = new String(array);
                       if(!newStr.equals(first) && set.contains(newStr)){ //若转化后的字符串在字典中，则将它加入队列，继续考察
                           queue.offer(newStr);
                           set.remove(newStr);
                       }
                   }
               }
           }
           level++;
       }
       return 0;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        String[] arr = {"hot","dot","dog","lot","log","cog"};
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        System.out.println(new ProblemWordladder().ladderLength(begin,end,list));
    }


}
