package com.chinalife.springmvc.algorithm.rowtooffer;

/** 判断二叉树是否是另一二叉树的子树
 * Created by chinalife on 2018/5/12.
 */
public class Problem17 {

    private StringBuilder strpre1 = new StringBuilder();
    private StringBuilder strpre2 = new StringBuilder();
    private StringBuilder strmid1 = new StringBuilder();
    private StringBuilder strmid2 = new StringBuilder();

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 ==null || root2 ==null)
            return false;
        preOrder1(root1);
        preOrder2(root2);
        premid1(root1);
        premid2(root2);
        if(strpre1.toString().contains(strpre2.toString()) &&
                strmid1.toString().contains(strmid2.toString()))
            return true;
        else
            return false;

    }

    private void preOrder1(TreeNode root){
        if(root ==null)
            return;
        strpre1.append(root.val);
        preOrder1(root.left);
        preOrder1(root.right);
    }
    private void preOrder2(TreeNode root){
        if(root ==null)
            return;
        strpre2.append(root.val);
        preOrder2(root.left);
        preOrder2(root.right);
    }
    private void premid1(TreeNode root){
        if(root ==null)
            return;
        premid1(root.left);
        strpre1.append(root.val);
        premid1(root.right);
    }

    private void premid2(TreeNode root){
        if(root ==null)
            return;
        premid2(root.left);
        strpre1.append(root.val);
        premid2(root.right);
    }

    private void insertTreeNodeLeft(TreeNode root ,int val){
        if(root.left ==null)
            root.left = new TreeNode(val);
        insertTreeNodeLeft(root.left,val);
    }
    private void insertTreeNodeRight(TreeNode root ,int val){
        if(root.right == null)
            root.right = new TreeNode(val);
        insertTreeNodeRight(root.right,val);
    }
    public static void main(String[] args) {
        Problem17 p  = new Problem17();
        TreeNode root1 = new TreeNode(1);
        p.insertTreeNodeLeft(root1,2);
        p.insertTreeNodeLeft(root1,3);
        p.insertTreeNodeRight(root1,4);


    }




}
