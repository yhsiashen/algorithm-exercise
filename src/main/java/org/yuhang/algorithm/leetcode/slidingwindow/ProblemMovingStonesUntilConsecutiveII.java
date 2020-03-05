package org.yuhang.algorithm.leetcode.slidingwindow;

import java.util.Arrays;

/**
 * 移动石子直到连续 LC1040
 * @tag:滑动窗口
 */
public class ProblemMovingStonesUntilConsecutiveII {


    public int[] numMovesStonesII(int[] stones) {
       Arrays.sort(stones);
       int n = stones.length;
       int max = Math.max(stones[n-1]-stones[1]-n+2,stones[n-2]-stones[0]-n+2);//求最多移动次数
       int min = n;
       for(int i=0,j=0;j<n;j++){
           while (stones[j] - stones[i]+1 > n){
               i++;
           }
           int already_stones = j-i+1;
           if(already_stones==n-1 && stones[j] -stones[i]+1 ==n-1){
               min = Math.min(min,2);
           }else{
               min = Math.min(min,n-already_stones);
           }
       }
       return new int[]{min,max};
    }

}
