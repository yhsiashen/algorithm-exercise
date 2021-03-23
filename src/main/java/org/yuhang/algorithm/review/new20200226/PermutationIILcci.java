package org.yuhang.algorithm.review.new20200226;

import java.util.*;

/**
 * 08.08 字符串的全排列
 */
public class PermutationIILcci {

    public String[] permutation(String S) {
         if(S.length() == 1) return new String[]{S};
         List<String> res  =  new ArrayList<>();
         boolean[] visited = new boolean[S.length()];
         char[] chs = S.toCharArray();
         Arrays.sort(chs);
         backtrace(res,visited,new String(chs),new StringBuilder());
         return res.toArray(new String[0]);
    }
    
    private void backtrace(List<String> res, boolean[] visited, String S,StringBuilder str){
        if(S.length() == str.length()){
            res.add(str.toString());
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            if(i>0 && S.charAt(i) == S.charAt(i-1) && !visited[i-1]) continue;
            if(!visited[i]){
                visited[i] = true;
                str.append(S.charAt(i));
                backtrace(res,visited,S,str);
                visited[i] = false;
                str.deleteCharAt(str.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationIILcci().permutation("qeq"));
    }
}
