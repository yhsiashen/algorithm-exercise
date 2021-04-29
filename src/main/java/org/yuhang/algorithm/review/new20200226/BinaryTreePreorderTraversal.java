package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
          List<Integer> res = new ArrayList<>();
          if(root == null) return res;
          Stack<TreeNode> stack = new Stack<>();
          stack.push(root);
          while (!stack.isEmpty()){
              TreeNode top = stack.pop();
              res.add(top.val);
              if(top.right!=null) stack.push(top.right);
              if(top.left!=null) stack.push(top.left);
          }
          return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new BinaryTreePreorderTraversal().preorderTraversal(root);
    }


}
