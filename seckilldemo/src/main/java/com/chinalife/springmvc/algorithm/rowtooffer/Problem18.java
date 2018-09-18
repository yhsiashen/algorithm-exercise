package com.chinalife.springmvc.algorithm.rowtooffer;

/** 二叉树的镜像
 * Created by chinalife on 2018/5/13.
 */
public class Problem18 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode tempNode;
    public void Mirror(TreeNode root) {
        if(root==null)
            return;
        ExchangeNode(root);
        Mirror(root.left);
        Mirror(root.right);

    }

    private void ExchangeNode(TreeNode root){
        tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

}
