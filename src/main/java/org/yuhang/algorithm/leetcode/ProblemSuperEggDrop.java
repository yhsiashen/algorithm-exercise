package org.yuhang.algorithm.leetcode;

import java.util.Arrays;

/**
 * 扔鸡蛋 LC887
 * TODO
 */
public class ProblemSuperEggDrop {

    int[][] cache;

    public int superEggDrop(int K, int N) {
        cache = new int[K][N];
        return dp(K,N);
    }

    private int dp(int k, int n) {
        if(k == 1) return n;//如果鸡蛋只有一个了，则只能从最底层开始扔,共需要n次
        if(n == 0) return 0;
        if(cache[k-1][n-1]!= 0){
            return cache[k-1][n-1];
        }

        int res = 0;
        for (int i = 1; i < n+1; i++) {//在所有楼层都尝试扔鸡蛋，按照二分的想法，找到所有楼层结果中的最小值
            //在i层楼扔鸡蛋，鸡蛋碎了，则往i-1~1层楼继续扔鸡蛋；若没有碎，则往i+1~N层楼继续扔鸡蛋
            res = Math.min(res, Math.max(dp(k,n-i),dp(k-1,i-1)))+1;
        }
        cache[k-1][n-1] = res;
        return res;
    }


    public static void main(String[] args) {

        String str=null;
        System.out.println(str.trim());
    }
}
