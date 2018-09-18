package com.chinalife.springmvc.algorithm.rowtooffer;

import java.util.ArrayList;

/**
 * 按层遍历打印二叉树(用List)
 * Created by chinalife on 2018/5/14.
 */
public class Problem22 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> valList = new ArrayList<Integer>();
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        TreeNode tempNode;
        if (root == null)
            return null;
        nodeList.add(root);
        while (true){
            tempNode = nodeList.remove(0);
            if(tempNode.left!=null){
                nodeList.add(tempNode.left);
            }
            if(tempNode.right!=null){
                nodeList.add(tempNode.right);
            }
            valList.add(tempNode.val);
            if(nodeList.size()==0){
                break;
            }
        }
        return valList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(11);
        list.add(22);
        list.add(33);
        System.out.println(list.remove(0));
        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
    }
}
