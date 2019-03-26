package org.yuhang.algorithm.leetcode.dynamicplan;

import java.util.ArrayList;
import java.util.List;

/** 不同的二叉搜索树 II  1,2,3...n可构成的二叉搜索树 TODO
 * Created by chinalife on 2018/10/22.
 */
public class ProblemGenerateTrees {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<TreeNode> generateTrees(int n) {
        //n个数字可构成的二叉搜索树的集合
        List<TreeNode> nodeList = new ArrayList<>();
        if(n<1)
            return nodeList;
        for (int i = 1; i <= n; i++) {
               
        }
        return nodeList;
    }
}
