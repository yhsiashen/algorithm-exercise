package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.ArrayList;
import java.util.List;

public class ProblemAllNodesDistanceKInBinaryTreeIII {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> res;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        res = new ArrayList<>();
        if(K==0){
            res.add(target.val);
        }else{
            dfs(root, target, K);
        }
        return res;
    }

    private int dfs(TreeNode root, TreeNode target, int K) {
        if (root == null) return -1;
        if (root == target) {
            subDfs(root.left, 1, K);
            subDfs(root.right, 1, K);
            return 0;
        }
        int L = dfs(root.left, target, K) + 1;
        int R = dfs(root.right, target, K) + 1;
        if (L > 0) {//target在左子树
            if (L == K) res.add(root.val);
            subDfs(root.right, L + 1, K);
            return L;
        } else if (R > 0) {//target在右子树
            if (R == K) res.add(root.val);
            subDfs(root.left, R + 1, K);
            return R;
        } else {
            return -1;
        }

    }

    private void subDfs(TreeNode root, int dist, int K) {
        if (root == null || dist > K) return;
        if (dist == K) res.add(root.val);
        subDfs(root.left, dist + 1, K);
        subDfs(root.right, dist + 1, K);
    }

    public static void main(String[] args) {
        ProblemAllNodesDistanceKInBinaryTreeIII p = new ProblemAllNodesDistanceKInBinaryTreeIII();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        p.distanceK(node,node.left,2);
    }
}
