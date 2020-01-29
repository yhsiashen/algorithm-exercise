package org.yuhang.algorithm.leetcode.array;


/**
 * 使数组唯一的最小增量 LC945
 */
public class ProblemMinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        int[] counts = new int[40000];
        int res = 0;
        for(int a:A) counts[a]++;
        for (int i = 0; i < counts.length;) {
            if(counts[i] > 1){
                int j = i;
                while (counts[j] > 1){
                    j++;
                }
                counts[i]--;
                counts[j]++;
                res += j-i;
            }else{
                i++;
            }
        }

        return res;
    }


    public int minIncrementForUnique1(int[] A) {
        int[] count = new int[100000];
        for (int x: A) count[x]++;

        int ans = 0, taken = 0;

        for (int x = 0; x < 100000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        System.out.println(new ProblemMinimumIncrementToMakeArrayUnique().minIncrementForUnique1(new int[]{2,2,2,1}));
    }
}
