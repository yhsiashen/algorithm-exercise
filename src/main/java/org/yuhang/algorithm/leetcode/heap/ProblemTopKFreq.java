package org.yuhang.algorithm.leetcode.heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 返回数组中前K个高频率的单词 LC692
 */
public class ProblemTopKFreq {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length ; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>(k, (o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o2.compareTo(o1);//相同频率按字母降序，堆顶元素字母表顺序最大，在后面会反转
            } else {
                return map.get(o1) - map.get(o2); //按频率升序的小顶堆，堆顶元素频率最小
            }
        });

        for(String str : map.keySet()){
            queue.add(str);
            if(queue.size() > k) queue.poll();
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()){
            res.add(queue.poll());
        }
        Collections.reverse(res);//反转列表
        return res;
    }

    public static void main(String[] args) {
//        System.out.println("love".compareTo("i"));
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        new ProblemTopKFreq().topKFrequent(words,2);


    }
}
