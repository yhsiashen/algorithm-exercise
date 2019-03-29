package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 验证二叉树是否为二叉搜索树 98
 * Created by chinalife on 2018/11/22.
 */
public class ProblemIsValidBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    double last = -Double.MAX_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
