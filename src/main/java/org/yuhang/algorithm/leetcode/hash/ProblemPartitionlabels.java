package org.yuhang.algorithm.leetcode.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间 LC763
 */
public class ProblemPartitionlabels {

    public List<Integer> partitionLabels(String S) {
          List<Integer> res = new ArrayList<>();
          int[] counts = new int[26];
          for (int i = 0; i < S.length(); i++) {
            counts[S.charAt(i) - 'a']++;
          }
          int left = 0,right = 0;
          int[] windowCount = new int[26];
          while (right < S.length()){
              windowCount[S.charAt(right)-'a']++;
              int i = 0;
              while(i<26){
                  if(windowCount[i]!= 0 && windowCount[i]!=counts[i]){
                      break;
                  }
                  i++;
              }

              if(i==26){
                  res.add(right-left+1);
                  left = right+1;
              }
              right++;
          }
          return res;
    }

    public List<Integer> partitionLabels1(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i)-'a'] = i;//存字符在S中出现的最后位置
        }

        ArrayList<Integer> res = new ArrayList<>();
        int j =0,anchor = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, lastIndex[S.charAt(i)-'a']);
            if(j == i){
               res.add(j-anchor+1);
               anchor = j+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new ProblemPartitionlabels().partitionLabels("ababcbacadefegdehijhklij");
    }
}
