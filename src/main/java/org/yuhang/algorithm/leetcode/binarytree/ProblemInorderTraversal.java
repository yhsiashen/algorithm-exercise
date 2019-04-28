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

    /**
     * 递归法
     * @param root
     * @return
     */
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

    public List<Integer> inorderTraversalByIterator(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            //将p的左子树全部压入栈中
            while (p!=null){
               stack.push(p);
               p=p.left;
           }
           //取栈顶元素，即为第一个元素，加入结果list中
           p = stack.pop();
           list.add(p.val);
           //p指向p的右子树
           p = p.right;
        }
      return list;
    }
}
