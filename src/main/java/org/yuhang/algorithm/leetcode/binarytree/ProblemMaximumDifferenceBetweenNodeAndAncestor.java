package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 祖先节点与节点差值的最大绝对值  1026
 */
public class ProblemMaximumDifferenceBetweenNodeAndAncestor {


     // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

     int res;

    /**
     * DFS1
     * @param root
     * @return
     */
    public int maxAncestorDiff(TreeNode root) {
       if(root == null) return 0;
       int rootVal = root.val;
       DFS(root.left,rootVal);
       DFS(root.right,rootVal);
       maxAncestorDiff(root.left); //考察左子树的最大差异值
       maxAncestorDiff(root.right); //考察右子树的最大差异值
       return res;
    }

    private void DFS(TreeNode node,int rootVal){
        if(node == null) return;
        int nodeVal = node.val;
        int diffVal = Math.abs(rootVal-nodeVal);
        res = Math.max(diffVal,res); //每次遍历考察当前节点和根节点的差值与res的大小，维护一个最大的res
        DFS(node.left,rootVal);
        DFS(node.right,rootVal);
    }


    private int maxDiff;

    /**
     * DFS2
     * @param root
     * @return
     */
    public int maxAncestorDiff1(TreeNode root) {
        calculateMaxDiff(root, root.val, root.val);

        return maxDiff;
    }

    private void calculateMaxDiff(TreeNode root, int maxAncestor, int minAncestor) {
        if (root == null) {
            return;
        }
        // we only have positive values
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(root.val - minAncestor), Math.abs(maxAncestor - root.val)));
        maxAncestor = root.val > maxAncestor ? root.val : maxAncestor; //维护一个最大的祖先
        minAncestor = root.val < minAncestor ? root.val : minAncestor; //维护一个最小的祖先
        calculateMaxDiff(root.left, maxAncestor, minAncestor);
        calculateMaxDiff(root.right, maxAncestor, minAncestor);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(new ProblemMaximumDifferenceBetweenNodeAndAncestor().maxAncestorDiff(root));
    }
}
