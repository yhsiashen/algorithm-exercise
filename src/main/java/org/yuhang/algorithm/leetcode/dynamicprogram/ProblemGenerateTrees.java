package org.yuhang.algorithm.leetcode.dynamicprogram;


import java.util.ArrayList;
import java.util.List;

/** 不同的二叉搜索树 II  1,2,3...n可构成的二叉搜索树  95
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
        if(n == 0) return new ArrayList<>();
        return DFS(1,n);//从数字1开始遍历所有路径
    }

    /**
     * DFS构建树
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> DFS(int start,int end){
       List<TreeNode> res = new ArrayList<>();
       if(start > end){
           res.add(null);
           return res;
       }
        for (int i = start; i <= end; i++) { //分别以start,start+1...end为根节点，求二叉搜索树的所有情况
           List<TreeNode> leftTree = DFS(start,i-1); //i为根节点的左子树路径结果
           List<TreeNode> rightTree = DFS(i+1,end); //i为根节点的右子树路径结果
            for (TreeNode left:leftTree) {
                for (TreeNode right:rightTree) {
                    TreeNode node = new TreeNode(i); //拼接左右子树，构建一个数并加入结果中
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
