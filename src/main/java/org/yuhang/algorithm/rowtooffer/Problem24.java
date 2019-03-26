package org.yuhang.algorithm.rowtooffer;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径集合
 * Created by chinalife on 2018/5/24.
 */
public class Problem24 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    // 所有路径的list
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> onePathlist = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return list;
        onePathlist.add(root.val);
        target-=root.val;
        if(target == 0 && root.left==null && root.right==null)
            list.add(new ArrayList<Integer>(onePathlist));
        FindPath(root.left, target);
        FindPath(root.right, target);
        onePathlist.remove(onePathlist.size()-1);
        return list;
    }

}
