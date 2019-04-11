package org.yuhang.algorithm.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

/** 打家劫舍3 337
 * Created by chinalife on 2018/12/4.
 */
public class ProblemRob3 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


     private Map<TreeNode,Integer> map = new HashMap<>();
    /**
     * dfs遍历所有结果找出最大值
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int val = root.val;
        //取该节点就不取该节点的左右子树
        if(root.left!=null){
            val += rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            val += rob(root.right.left)+rob(root.right.right);
        }

        int maxMoney = Math.max(val,rob(root.left)+rob(root.right));
        map.put(root,maxMoney);
        return maxMoney;

    }


}
