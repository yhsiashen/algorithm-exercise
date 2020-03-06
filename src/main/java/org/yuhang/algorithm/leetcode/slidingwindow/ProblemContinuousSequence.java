package org.yuhang.algorithm.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 * @tag:滑动窗口
 */
public class ProblemContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        if(target<=2) return new int[][]{};
        List<int[]> list= new ArrayList<>();
        int left = 1, right = 2;
        while (left+right <= target){
            int sum = ((left+right)*(right-left+1))/2;
            if(sum==target){
                int[] res = new int[right-left+1];
                res[0] = left;
                for (int i = 1; i < right-left+1; i++) {
                    res[i] = res[i-1]+1;
                }
                list.add(res);
                left++;
            }else if(sum < target){
                right++;
            }else{
                left++;
            }
        }
        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        System.out.println(new ProblemContinuousSequence().findContinuousSequence(15));
    }
}
