package org.yuhang.algorithm.leetcode.unionfind;

import java.util.*;

/**
 * 账户合并 LC721
 */
public class ProblemAccountsMerge {


    class UnionFind{
        int[] parent;
        int[] size;

        public UnionFind(){
            parent = new int[20001];
            size = new int[20001];
            for (int i = 0; i < 20001; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p){
            while (parent[p]!=p){
                 p = parent[parent[p]];
            }
            return p;
        }

        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(size[rootP] > size[rootQ]){
                size[rootP] += size[rootQ];
                parent[rootQ] = rootP;
            }else {
                size[rootQ] += size[rootP];
                parent[rootP] = rootQ;
            }
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String,String> emailToName = new HashMap<>();
        Map<String,Integer> emailToID = new HashMap<>();
        int id = 0;
        for (List<String> account:accounts){//将每个邮箱作为图中的一个节点，同一个账户下的邮箱连通，为了方便，保存一下账户名在返回结果时用到
            String name = "";
            for(String email:account){
                if("".equals(name)){
                    name = email;
                    continue;
                }
                emailToName.put(email,name);
                if(!emailToID.containsKey(email)){
                    emailToID.put(email,id++);
                }
                uf.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }
        Map<Integer,List<String>> ans = new HashMap<>();
        for(String email: emailToName.keySet()){
            int parent = uf.find(emailToID.get(email));//根据邮箱找到连通分量的根节点
            ans.computeIfAbsent(parent, x -> new ArrayList<>()).add(email);
        }

        for(List<String> value:ans.values()){
            Collections.sort(value);
            value.add(0, emailToName.get(value.get(0)));
        }


        return new ArrayList<>(ans.values());
    }
}
