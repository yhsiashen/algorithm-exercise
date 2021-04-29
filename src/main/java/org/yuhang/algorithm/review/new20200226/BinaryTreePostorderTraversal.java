package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
           TreeNode cur = stack.pop();
           res.add(cur.val);
           if(cur.left!=null) stack.push(cur.left);
           if(cur.right!=null) stack.push(cur.right);
        }
        Collections.reverse(res);
        return res;
    }
}
