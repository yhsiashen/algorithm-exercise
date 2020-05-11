package org.yuhang.algorithm.review;

/**
 * 不同路径 LC62
 */
public class UniquePaths {

    int[][] cache ;

    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 1;
         cache = new int[m+1][n+1];
        return unique(m,n);

    }

    private int unique(int m, int n) {
        if(m == 1 || n == 1) return 1;
        if(cache[m][n]!=0) return cache[m][n];
        int paths = unique(m-1,n)+unique(m,n-1);
        cache[m][n] = paths;
        return paths;
    }
}
