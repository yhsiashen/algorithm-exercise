package org.yuhang.algorithm.interview;

/**
 * 使数组唯一的最小增量
 */
public class ProblemMinIncrementForUnique {
    public int minIncrementForUnique(int[] A) {
        if(A.length == 0) return 0;
        int res = 0;
        int[] counts = new int[40000];
        for(int a:A) counts[a]++;
        for (int i = 0; i <counts.length ; i++) {
            if(counts[i] > 1){
                res += counts[i]-1;
                counts[i+1] += counts[i]-1;
            }
        }


        return res;
    }
}
