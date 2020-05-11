package org.yuhang.algorithm.review;

/**
 * 将二叉树展开为链表 LC114
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null) {
            TreeNode left = root.left;
            TreeNode cur = left;
            while (cur.right!=null){
                cur = cur.right;
            }
            cur.right = root.right;
            root.right = left;
        }
        root.left =null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        new FlattenBinaryTreeToLinkedList().flatten(root);
    }
}
