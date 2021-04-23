package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 迭代法完成二叉树中序遍历
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        //栈模拟递归调用
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null){//将左子树全部压入栈
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()){//取出栈顶元素加入结果，同时将右子树的左子树压入栈
            TreeNode cur = stack.pop();
            res.add(cur.val);
            TreeNode right = cur.right;
            while (right!=null){
                stack.push(right);
                right = right.left;
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        return res;
    }

    private void dfs(TreeNode root,List<Integer> res){
        if(root == null) return;
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }


}
