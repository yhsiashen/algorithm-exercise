package org.yuhang.algorithm.leetcode.graphBFSDFS;

import java.util.*;

/**
 * 单词接龙II,输出单词接龙的转化路径 126  TODO
 */
public class ProblemWordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Queue<Deque<String>> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);//将List转换为HashSet提高查询效率
        Deque<String> eachQueue = new LinkedList<>();
        eachQueue.add(beginWord);
        queue.offer(eachQueue);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) { //将该level层的所有元素依次取出，匹配下一个单词
                Deque<String> firstQueue = queue.poll();
                String LastEle = firstQueue.peekLast();//取路径队列的最后一个元素看是否匹配endword
                if(LastEle.equals(endWord)) { //最先匹配到endword的这一层是最短路径，将最短路径都放入res中，然后结束遍历
                    res.add(new ArrayList<>(firstQueue));
                    continue;
                }
                for (int j = 0; j < LastEle.length(); j++) { //遍历first字符串的每个元素
                    char[] array = LastEle.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        array[j] = k; //将j位换成char k
                        String newStr = new String(array);
                        if(!newStr.equals(LastEle) && set.contains(newStr)){ //若转化后的字符串在字典中
                            Deque<String> theDeque = new LinkedList<>(firstQueue); //new一个队列，存储一条可能的路径
                            theDeque.offer(newStr);
                            queue.offer(theDeque);
//                            if(!newStr.equals(endWord)) set.remove(newStr); //将该词从set中移除
                        }
                    }
                }
            }
            if(!res.isEmpty()) break; //若res已有路径了，则证明找到了所有的最短路径，直接break掉BFS的循环

        }
      return res;
    }

    public static void main(String[] args) {
        String begin = "red";
        String end = "tax";
        List<String> list = new ArrayList<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
        new ProblemWordLadderII().findLadders(begin,end,list);
    }
}
