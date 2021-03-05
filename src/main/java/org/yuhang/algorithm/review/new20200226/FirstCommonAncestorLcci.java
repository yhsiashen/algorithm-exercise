package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

/**
 * 04.8 首个共同祖先
 */
public class FirstCommonAncestorLcci {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root ==null || root==p || root==q) return root;
         TreeNode left=  lowestCommonAncestor(root.left,p,q);//在左子树中找公共祖先
         TreeNode right = lowestCommonAncestor(root.right,p,q);//在右子树中找公共祖先
         if(left!=null && right!=null) return root;
         return left==null?right:left;
    }
}
