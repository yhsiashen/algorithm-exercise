package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 求二叉树的最大深度
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
