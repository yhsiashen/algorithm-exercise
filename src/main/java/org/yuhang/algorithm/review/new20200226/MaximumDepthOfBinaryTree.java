package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

/**
 * 二叉树的最大深度
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
