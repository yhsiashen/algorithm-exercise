package org.yuhang.algorithm.review;

/**
 * 从前序遍历与中序遍历中构造二叉树 LC105
 */
public class ConstructBinaryTreeFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if(l1>r1 || l2>r2) return null;
        TreeNode root = new TreeNode(preorder[l1]);
        int index = -1;//中序遍历中根节点在的索引
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[l1]){
                index = i;
                break;
            }
        }
        root.left = build(preorder,l1+1,l1+index-l2,inorder,l2,l2+index-1);
         root.right = build(preorder,l1+index-l2+1,r1,inorder,index+1,r2);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        new ConstructBinaryTreeFromPreorderAndInorder().buildTree(new int[]{1,2,3},new int[]{2,3,1});
    }
}
