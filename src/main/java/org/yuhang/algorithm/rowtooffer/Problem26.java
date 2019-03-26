package org.yuhang.algorithm.rowtooffer;

/**
 * 将二叉搜索树转换为排序的双向链表
 * Created by chinalife on 2018/6/4.
 */
public class Problem26 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void insertNode(TreeNode node, int val){
        if(node == null)
            return;
        if(val<= node.val){
            if(node.left == null){
                node.left = new TreeNode(val);
                return;
            }
            insertNode(node.left,val);
        }else{
            if(node.right == null){
                node.right = new TreeNode(val);
                return;
            }
            insertNode(node.right,val);
        }

    }

    /**
     * 递归
     * @param pRootOfTree
     * @return
     */
    private TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;
        //用递归将左子树构造成双向链表并返回左子树
        TreeNode leftnode  = Convert(pRootOfTree.left);
        TreeNode p = leftnode;
        //找到链表的尾部节点
        while(p !=null && p.right!=null){
            p = p.right;
        }
        //将链表尾部追加上根节点
        if(p != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        //用递归将右子树构造成双向链表
        TreeNode rightnode = Convert(pRootOfTree.right);
        //将左右子树链表合起来
        if(rightnode!=null) {
            pRootOfTree.right = rightnode;
            rightnode.left = pRootOfTree;
        }
        return leftnode !=null ?leftnode:pRootOfTree;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        insertNode(root,3);
        insertNode(root,7);
        insertNode(root,1);
        insertNode(root,4);
        insertNode(root,2);
        insertNode(root,6);
        insertNode(root,8);
        new Problem26().Convert(root);

    }
}
