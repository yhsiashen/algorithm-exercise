package org.yuhang.algorithm.leetcode.array;


/**
 * 使数组唯一的最小增量 LC945
 */
public class ProblemMinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        int[] counts = new int[50000];
        int res = 0;
        for(int a:A) counts[a]++;

        for (int i = 0; i < counts.length;i++) {//一次遍历，将多余的数依次累加到后面一个数上
            if(counts[i] > 1){
                res += counts[i]-1;
                counts[i+1] += counts[i] -1;
                counts[i] = 1;
            }
        }

        return res;
    }




    public static void main(String[] args) {
        System.out.println(new ProblemMinimumIncrementToMakeArrayUnique().minIncrementForUnique(new int[]{2,2,2,1}));
    }
}
