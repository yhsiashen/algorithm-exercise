package org.yuhang.algorithm.review;

/**
 * 验证二叉搜索树 LC98
 */
public class ValidateBST {

    //测试用例用Integer.MIN_VALUE的值
    long preMax = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(isValidBST(root.left)){
            if(root.val > preMax){
                preMax = root.val;
                return isValidBST(root.right);
            }

        }

        return false;


    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }


}
