package org.yuhang.algorithm.leetcode.binarytree;


/**
 * 将有序数组转化为二叉搜索树 LC108
 */
public class ProblemConvertSortedArrayToBST {


     //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode sortedArrayToBST(int[] nums) {
         if(nums.length == 0) return null;
         TreeNode root =  generateTree(nums,0,nums.length-1);
         return root;
    }

    private TreeNode generateTree(int[] nums,int left,int right){
          if(left == right){
             return new TreeNode(nums[left]);
          }else if(left > right){
             return null;
          }
          int mid = (left + right)/2;
          TreeNode root = new TreeNode(nums[mid]);
          root.left = generateTree(nums,left,mid-1);
          root.right = generateTree(nums,mid+1,right);
          return root;
    }

    public static void main(String[] args) {
          int[] nums = {-10,-3,0,5,9};
        new ProblemConvertSortedArrayToBST().sortedArrayToBST(nums);
    }
}
