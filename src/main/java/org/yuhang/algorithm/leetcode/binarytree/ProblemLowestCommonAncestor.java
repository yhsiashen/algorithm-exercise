package org.yuhang.algorithm.leetcode.binarytree;

/** 求二叉树指定两节点的最近公共祖先 236
 * Created by chinalife on 2018/11/30.
 */
public class ProblemLowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode result =null;
    int maxDepth = Integer.MIN_VALUE;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        DFS(root,p,q,0);
        return result;
    }

    private void DFS(TreeNode root, TreeNode p, TreeNode q,int depth){
        if(root ==null) {
            return;
        }
        //若root是p和q的公共祖先,则判断此时的祖先是否是目前最近的祖先
        if(isParentNode(root,p) && isParentNode(root,q) && depth > maxDepth) {
            result = root;
            maxDepth = depth;
        }
        DFS(root.left,p,q,depth+1);
        DFS(root.right,p,q,depth+1);
    }

    /**
     * 判断root是否是node的祖先
     * @param root
     * @param node
     * @return
     */
    private boolean isParentNode(TreeNode root ,TreeNode node){
        if(root==null) return false;
        if(root.val == node.val) return true;
        return isParentNode(root.left,node) || isParentNode(root.right,node);
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q){
        //若root为p或q之一，则直接返回
        if(root==null || root.val == p.val || root.val ==q.val) return root;
        //左子树为p或q之一的祖先
        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        //右子树为p或q之一的祖先
        TreeNode right = lowestCommonAncestor1(root.right,p,q);

        if(left!=null && right!=null) return root;

        return left==null ? right:left;


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p =root;
        p.left = new TreeNode(5);
        p.right = new TreeNode(1);
        p = p.left;
        p.left = new TreeNode(6);
        p.right = new TreeNode(2);
        p.right.left = new TreeNode(7);
        p.right.right = new TreeNode(4);
        TreeNode q = root.right;
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        new ProblemLowestCommonAncestor().lowestCommonAncestor(root,p,q);
    }
}
