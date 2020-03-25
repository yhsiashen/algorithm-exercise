package org.yuhang.algorithm.interview;

import java.util.*;

/**
 * 输出字符串的所有排列
 */
public class ProblemStringPermutation {

    public String[] permutation(String s) {
       Set<String> set = new HashSet<>();
       boolean[] visited = new boolean[s.length()];
       dfs(s,new StringBuilder(),set,visited);
       return set.toArray(new String[]{});
    }

    private void dfs(String s, StringBuilder pre, Set<String> set,boolean[] visited) {
        if(pre.length() == s.length()){
            set.add(pre.toString());
            return;
        }
        for (int i = 0; i < s.length() ; i++) {
            if(!visited[i]){
                 if(i>0 && !visited[i-1] && s.charAt(i) == s.charAt(i-1)) continue;//当当前字母和前一个字母相同且之前的字母没被访问过(说明这次遍历是以此字母开始的)，跳过此字母的所有可能解
                 visited[i] = true;
                 pre.append(s.charAt(i));
                 dfs(s, pre, set, visited);
                 pre.deleteCharAt(pre.length()-1);//回溯
                 visited[i] = false;//回溯
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ProblemStringPermutation().permutation("aabc"));
    }
}
