package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;


/**
 * 返回二叉树的所有路径  257
 */
public class ProblemBinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
          List<String> list = new ArrayList<>();
          if(root == null) return list;
          DFS(root,null,list);
          return list;
    }

    private void DFS(TreeNode node,String str,List<String> list){
        if(node==null) return;
        if(node.left==null && node.right==null) {//已遍历到叶子节点，将路径加入list中
            list.add(str+ node.val);
            return;
        }
        str = str+node.val+"->";
        DFS(node.left,str,list);
        DFS(node.right,str,list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        new ProblemBinaryTreePaths().binaryTreePaths(root);
    }
}
