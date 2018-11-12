package org.yuhang.algorithm.leetcode.dynamicplan;

/** 动态规划算法 (LCS-最长公共子序列)
 * Created by yuhang on 2018/3/22.
 */
public class DynamicProgramming {

    private static int[][] c ;

    private static int LCS(String[] a, String[] b, int i, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }

        if (a[i].equals(b[j])) {
            c[i][j] = LCS(a, b, i - 1, j - 1) + 1;
        } else {
            int m = LCS(a, b, i, j - 1);
            int n = LCS(a, b, i - 1, j);
            if (m > n) {
                c[i][j] = m;
            } else {
                c[i][j] = n;
            }
        }
        return c[i][j];

    }

    public static void main(String[] args) {
        String[] a = {"A","A","A","C","D","B"};
        String[] b = {"A","B","A","C","B","D","C","B"};
        c = new int[a.length][b.length];
        System.out.println(LCS(a,b,a.length-1,b.length-1));
    }
}
