package org.yuhang.algorithm.leetcode.dfs;

/**
 * Created by chinalife on 2018/11/23.
 */
public class ProblemIsBalancedTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        //判断根节点是否平衡
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
            return false;
        }
        //遍历左子树，判断左子树的每个节点是否平衡
        if(!isBalanced(root.left))
            return false;
        //遍历右子树，判断右子树的每个节点是否平衡
        if(!isBalanced(root.right))
            return false;
        return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


}
