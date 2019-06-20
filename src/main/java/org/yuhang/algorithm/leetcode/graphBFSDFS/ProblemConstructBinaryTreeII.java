package org.yuhang.algorithm.leetcode.graphBFSDFS;

import java.util.Arrays;

/**
 * 从中序遍历和后序遍历构造二叉树 106
 */
public class ProblemConstructBinaryTreeII {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 后序遍历最后一个元素一定是根元素
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(inorder.length == 0) return null;
         if(inorder.length == 1) return new TreeNode(inorder[0]);
         int rootIndex = 0;
         while (true){
             if(inorder[rootIndex] != postorder[postorder.length-1]){
                 rootIndex++;
             }else{
                 break;
             }
         }
         TreeNode root = new TreeNode(inorder[rootIndex]);

         int[] inleft = Arrays.copyOfRange(inorder,0,rootIndex);
         int[] inright = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
         int[] postleft = Arrays.copyOfRange(postorder,0,rootIndex);
         int[] postright = Arrays.copyOfRange(postorder,rootIndex,postorder.length-1);

         root.left = buildTree(inleft,postleft);
         root.right = buildTree(inright,postright);
         return root;
    }
}
