package org.yuhang.algorithm.leetcode.array;

/**
 * 最多能完成排序的块 LC769
 */
public class ProblemMaxchunkstoMakeSorted {

    public int maxChunksToSorted(int[] arr) {
      int res = 0,max = 0;
      for (int i = 0; i < arr.length; i++) {
         max = Math.max(arr[i],max);
         if(max == i) res++;
      }
      return res;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(new ProblemMaxchunkstoMakeSorted().maxChunksToSorted(arr));
    }
}
