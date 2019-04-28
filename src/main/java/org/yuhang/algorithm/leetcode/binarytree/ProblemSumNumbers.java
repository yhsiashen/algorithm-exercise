package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 求根到叶子节点的之和
 */
public class ProblemSumNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public int sumNumbers(TreeNode root) {
//        DFS(root,"",list);

        DFS1(root,0);
        return sum;
//        int sum = 0;
//        for (String s: list) {
//            int pathSum = 0;
//            String[] numStr = s.split("->");
//            for (int i = 0; i < numStr.length ; i++) {
//                pathSum+=Integer.parseInt(numStr[i]) * Math.pow(10,numStr.length-i-1);
//            }
//            sum+=pathSum;
//        }
//        return sum;
    }

    private void DFS1(TreeNode node,int pathSum){
        if(node == null) return;
        if(node.left == null && node.right == null) {
            pathSum=pathSum*10+node.val;
            sum+=pathSum;
            return;
        }
        pathSum=pathSum*10+node.val;
        DFS1(node.left,pathSum);
        DFS1(node.right,pathSum);
    }

    private void DFS(TreeNode node, String str, List<String> list){
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
        new ProblemSumNumbers().sumNumbers(root);
//        System.out.println(Integer.parseInt("2")*10^2);
    }
}
