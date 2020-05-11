package org.yuhang.algorithm.review;

/**
 * 二叉树的最近公共祖先
 */
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left =  lowestCommonAncestor(root.left,p,q);//在左子树中找公共祖先
        TreeNode right = lowestCommonAncestor(root.right,p,q);//在右子树中找公共祖先
        if(left!=null && right!=null) return root;//如果左右子树都找出了不为null的TreeNode，则说明公共祖先是root
        return left==null?right:left;//若有一个为null，则另一个为公共祖先


    }
}
