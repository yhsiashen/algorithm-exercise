package org.yuhang.algorithm.leetcode.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ProblemSortCharactersByFrequency {

    public String frequencySort(String s){
        if(s.length() == 0) return s;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder res  = new StringBuilder();
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1,o2)->map.get(o2)-map.get(o1));
        for(Character c:map.keySet()){
           priorityQueue.add(c);
        }
        while (!priorityQueue.isEmpty()){
            char c = priorityQueue.poll();
            int count = map.get(c);
            while (count>0){
                res.append(c);
                count--;
            }

        }
        return res.toString();
    }
}
