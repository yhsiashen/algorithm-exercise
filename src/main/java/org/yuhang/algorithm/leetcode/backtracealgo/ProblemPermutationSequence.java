package org.yuhang.algorithm.leetcode.backtracealgo;



import java.util.ArrayList;
import java.util.List;

/**
 * 找到第k个排列 LC60
 * @tag:回溯算法
 */
public class ProblemPermutationSequence {


    public String getPermutation(int n, int k) {
        if(n == 1) return "1";
        boolean[] visited = new boolean[n+1];
        List<String> list = new ArrayList<>();
        backtrace(n,k,visited,new StringBuilder(),list);
        return list.get(k-1);
    }

    private void backtrace(int n,int k,boolean[] visited,StringBuilder one ,List<String> list){
        if(list.size() == k){
            return;
        }

        if(one.length() == n){
            list.add(one.toString());
            return;
        }



        for (int i = 1; i <=n ; i++) {
            if(!visited[i]){
                visited[i] = true;
                one.append(i);
                backtrace(n,k,visited,one,list);
                one.deleteCharAt(one.length()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ProblemPermutationSequence().getPermutation(3,3));
    }
}
