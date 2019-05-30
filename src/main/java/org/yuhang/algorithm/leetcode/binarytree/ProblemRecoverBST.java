package org.yuhang.algorithm.leetcode.binarytree;


/**
 * 恢复二叉搜索树，不能改变树的结构
 */
public class ProblemRecoverBST {


      //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

     TreeNode t1,t2,pre;

    /**
     * 中序遍历root树，遍历过程中正常的树一定满足left.val < root.val < right.val，
     * 若不满足的，则为错误节点(t1,t2)，记录这两个错误节点，遍历完毕后交换即可
     * @param root
     */
    public void recoverTree(TreeNode root) {
        midOrderTree(root);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }


    private void midOrderTree(TreeNode root){
        if(root == null) return;

        midOrderTree(root.left);

        if(pre!=null && pre.val > root.val){ //判断前一个节点是否大于当前节点(BST的特性是前一个节点必定小于当前节点)
            if(t1 ==null) t1 = pre;//记录第一个错误节点
            t2 = root;//记录第二个错误节点
        }
        pre = root; //记录pre节点

        midOrderTree(root.right);
    }
}
