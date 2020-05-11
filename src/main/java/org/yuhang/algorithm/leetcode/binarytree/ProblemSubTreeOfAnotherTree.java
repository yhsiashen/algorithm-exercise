package org.yuhang.algorithm.leetcode.binarytree;

import org.yuhang.algorithm.review.TreeNode;

/**
 * 另一个树的子树 LC572
 */
public class ProblemSubTreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }

        if(isSame(s,t)){
            return true;
        }else{
            return isSubtree(s.left,t) || isSubtree(s.right,t);
        }

    }

    /**
     * 判断s和t是否一致
     * @param s
     * @param t
     * @return
     */
    private boolean isSame(TreeNode s, TreeNode t){
        if(t == null){
            return s == null;
        }
        if(s == null) {
            return false;
        }

        if(s.val == t.val){
            return isSame(s.left,t.left) && isSame(s.right,t.right);
        }
        return false;
    }


}
