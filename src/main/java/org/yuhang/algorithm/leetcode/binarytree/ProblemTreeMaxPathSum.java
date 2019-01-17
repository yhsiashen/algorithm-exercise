package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 二叉树的最大路径和 124
 * Created by chinalife on 2018/12/3.
 */
public class ProblemTreeMaxPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        //求节点左子树的最大路径，若为正数，则记录
        int left = Math.max(dfs(node.left), 0);
        //求节点右子树的最大路径
        int right = Math.max(dfs(node.right), 0);
        //更新目前的最大路径,左右子树的路径+根节点的路径
        res = Math.max(res, left + right + node.val);
        //返回左右路径的最大值,即root节点的最大路径
        return Math.max(left, right) + node.val;


    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(new ProblemTreeMaxPathSum().maxPathSum(node));

    }


}
