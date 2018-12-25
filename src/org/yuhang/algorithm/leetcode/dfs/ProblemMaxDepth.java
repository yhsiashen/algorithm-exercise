package org.yuhang.algorithm.leetcode.dfs;

/**
 * Created by chinalife on 2018/11/23.
 */
public class ProblemMaxDepth {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
