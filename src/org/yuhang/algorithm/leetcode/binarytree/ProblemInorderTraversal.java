package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历 94
 * Created by chinalife on 2018/11/27.
 */
public class ProblemInorderTraversal {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> listInter = new ArrayList<Integer>();
        if (root == null) {
            return listInter;
        }
        if (root.left != null) {
            listInter.addAll(inorderTraversal(root.left));
        }
        listInter.add(root.val);
        if (root.right != null) {
            listInter.addAll(inorderTraversal(root.right));
        }
        return listInter;
    }
}
