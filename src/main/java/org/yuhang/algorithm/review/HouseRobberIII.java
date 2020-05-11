package org.yuhang.algorithm.review;

import java.util.HashMap;

/**
 * 打家劫舍III LC337
 */
public class HouseRobberIII {

    private HashMap<TreeNode,Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
       if(root == null) return 0;
       if(map.containsKey(root)) return map.get(root);
       //选择偷当前节点，则左右子树的节点不能偷
       int left = 0, right = 0;
       if(root.left!=null){
           left = rob(root.left.left)+rob(root.left.right);
       }

       if(root.right!=null){
           right = rob(root.right.left) + rob(root.right.right);
       }

       int res = Math.max(left+right+root.val , rob(root.left)+rob(root.right));
       map.put(root,res);
       return res;
    }



}
