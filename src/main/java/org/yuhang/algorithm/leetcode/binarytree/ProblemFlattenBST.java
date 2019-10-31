package org.yuhang.algorithm.leetcode.binarytree;


/**
 * 将二叉树展开为链表 LC114
 */
public class ProblemFlattenBST {


    // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 将root右子树接到root左子树的最右节点的右子树上，然后将root左子树的最右节点接到root的右子树上
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root !=null){
            //若左子树为null，直接考虑右节点
            if(root.left == null) {
                root = root.right;
            }else {
                TreeNode left = root.left;
                while (left.right !=null) {//找到左子树的最右一个节点
                    left = left.right;
                }

                left.right = root.right; //在这个节点的右子树接上root的右子树
                root.right = root.left; //root的左子树接到右子树上
                root.left = null; //root左子树置空
                root = root.right; //进行下一个节点的展开
            }
        }
    }

    private TreeNode pre;

    /**
     * 递归，从最右子节点开始往回加节点
     * @param root
     */
    public void flatten2(TreeNode root){
          if(root == null) return;
          flatten2(root.right);
          flatten2(root.left);
          root.right = pre; //用pre节点保存之前已接好的'链表'，将pre加到root的右子树上
          root.left = null; //root左子树置空
          pre = root; // pre指向root
    }


}
