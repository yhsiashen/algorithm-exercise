package org.yuhang.algorithm.review;

/**
 * 不同的二叉搜索树 LC96
 */
public class UniqueBST {

    public int numTrees(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //二叉搜索树的左右子树均为二叉搜索树，以j为根节点，其左子树节点个数为j-1,右子树个数为n-j
        for (int i = 2; i <n+1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j-1]*dp[i-j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBST().numTrees(3));
    }
}
