package org.yuhang.algorithm.leetcode.unionfind;

import java.util.*;

/**
 * 交换字符串中的元素 LC1202
 */
public class ProblemSmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0) return s;
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> pair:pairs){
            uf.union(pair.get(0),pair.get(1));
        }
        char[] chs = s.toCharArray();
        Map<Integer,List<Integer>> components = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
           int root = uf.find(i);//每个连通分量为一个map中的一个entry，连通分量的root为key
           components.computeIfAbsent(root, x->new ArrayList<>()).add(i);
        }

        for(List<Integer> component:components.values()){
            char[] tmp = new char[component.size()];
            for (int i = 0; i <tmp.length ; i++) {
                tmp[i] = chs[component.get(i)];
            }
            Arrays.sort(tmp);
            for (int i = 0; i < tmp.length; i++) {
                chs[component.get(i)] = tmp[i];
            }
        }
        StringBuilder res = new StringBuilder();
        for(char ch:chs) res.append(ch);

        return res.toString();

    }
}
