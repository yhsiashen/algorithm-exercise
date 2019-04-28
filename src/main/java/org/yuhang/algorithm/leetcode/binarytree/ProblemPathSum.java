package org.yuhang.algorithm.leetcode.binarytree;


import java.util.ArrayList;
import java.util.List;

/**
 * 求二叉树路径总和等于给定值的所有集合  113
 */
public class ProblemPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        findAllPath(root, new ArrayList<>(),0,sum, result);
        return result;
    }

    private void findAllPath(TreeNode root, List<Integer> list, int pathSum, int sum,List<List<Integer>> result) {
        if(root == null) return;
        pathSum+=root.val;
        list.add(root.val);
        if(pathSum == sum && root.left==null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        findAllPath(root.left,list,pathSum,sum,result);
        findAllPath(root.right,list,pathSum,sum,result);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        new ProblemPathSum().pathSum(root,8);

    }
}
