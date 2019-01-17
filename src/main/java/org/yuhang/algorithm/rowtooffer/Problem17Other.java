package org.yuhang.algorithm.rowtooffer;

/**
 * 17的递归法
 * Created by chinalife on 2018/5/13.
 */
public class Problem17Other {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null)
                return false;
            if (root1.val == root2.val) {
                return isSubTree(root1, root2);
            }
            //若不相等，则继续递归root1的左/右子树匹配root2的根
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

        }

        private boolean isSubTree(TreeNode root1, TreeNode root2) {
            return root2 == null || root1 != null && root1.val == root2.val && isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }


}
