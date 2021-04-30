package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和II
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<List<Integer>> res = new ArrayList<>();
         if(root == null) return res;
         dfs(root, 0, targetSum, new ArrayList<>(), res);
         return res;
    }

    private void dfs(TreeNode node, int curSum, int targetSum, List<Integer> list, List<List<Integer>> res){
        if(node == null) return;
        curSum += node.val;
        list.add(node.val);
        if(targetSum == curSum && node.left == null && node.right == null){
            res.add(new ArrayList<>(list));
        }
        dfs(node.left, curSum,targetSum,list,res);
        dfs(node.right,curSum,targetSum,list,res);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        new PathSumII().pathSum(root, 22);
    }



}
