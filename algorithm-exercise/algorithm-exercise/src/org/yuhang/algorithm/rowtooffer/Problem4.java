package org.yuhang.algorithm.rowtooffer;

/** 根据二叉树的中序遍历和先序遍历重建二叉树
 * Created by yuhang on 2018/3/25.
 */
public class Problem4 {

    //定义二叉树节点类
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
         if(pre==null || in == null || pre.length != in.length){
             throw new RuntimeException("参数不合法");
         }
         return constructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    public TreeNode constructBinaryTree(int[] pre,int pmin,int pmax,int[] in ,int imin,int imax){
         if(pmin > pmax || imin >imax){
             return null;
         }
        //先序遍历序列的第一个值为树的根节点
        int val = pre[pmin];
        //找到根节点值在中序遍历中的位置，之前的序列为左子树序列
        int index = imin;
        while (index <= imax && in[index] != val){
            index++;
            if(index > imax){
                throw new RuntimeException("参数输入错误");
            }
        }
        //根节点=val
        TreeNode node = new TreeNode(val);
        //左子树=index前面的序列重建二叉树
        node.left = constructBinaryTree(pre,pmin+1,pmin+index-imin,in,imin,index-1);
        //右子树=index后面的序列重建二叉树
        node.right = constructBinaryTree(pre,pmin+index-imin+1,pmax,in,index+1,imax);
        return node;
    }




}
