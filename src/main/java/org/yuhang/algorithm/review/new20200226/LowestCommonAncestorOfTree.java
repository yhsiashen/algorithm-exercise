package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

/**
 * 二叉树最近公共祖先
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中
 *
 */
public class LowestCommonAncestorOfTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q|| root == p) return root;//root为null或者找到了p/q其中之一的节点，返回root
        TreeNode left = lowestCommonAncestor(root.left, p, q);//左子树中找p、q的最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right,p,q);//右子树中找p、q的最近公共祖先
        if(left!=null && right!=null) return root;
        return left==null?right:left;
    }
}
