package org.yuhang.algorithm.leetcode.graphBFSDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右视图 199
 */
public class ProblemBinaryTreeRightSideView {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res,1);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res, int level) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(res.size() < level) res.add(root.val);
            return;
        }

        if(res.size() < level){
            res.add(root.val);
        }

        helper(root.right,res,level+1);
        helper(root.left,res,level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        new ProblemBinaryTreeRightSideView().rightSideView(root);
    }


}
