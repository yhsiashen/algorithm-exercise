package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树(中序遍历是递增的)中第K大的节点
 */
public class KthLargest {

    public int kthLargest(TreeNode root, int k) {
         List<Integer> list = new ArrayList<>();
         dfs(root,list);
         return list.get(list.size()-k);

    }
    private void dfs(TreeNode node, List<Integer> list){
        if(node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right,list);
    }

    /**
     * 右->根->左是递减的,从右子树开始遍历,遇到的第k个数即为第k大
     * @param root
     * @param k
     * @return
     */
    public int kthLargest1(TreeNode root, int k) {
        helper(root,k);
        return ans;
    }

    int ans = 0;
    int count = 0;

    private void helper(TreeNode root, int k){
        if(root.right!=null) helper(root.right,k);
        if(++count==k) {
            ans = root.val;
            return;
        }
        if(root.left!=null) helper(root.left,k);
    }

    public static void main(String[] args) {
        TreeNode root  = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        new KthLargest().kthLargest1(root, 1);
    }
}
