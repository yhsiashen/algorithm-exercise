package com.chinalife.springmvc.algorithm.rowtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.chinalife.springmvc.algorithm.rowtooffer.Problem22.TreeNode;

/** 按层遍历打印二叉树(用Quene)
 * Created by chinalife on 2018/5/14.
 */
public class Problem22Other {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> valList = new ArrayList<Integer>();
        Queue<TreeNode> nodeQuene = new LinkedList<TreeNode>();
        TreeNode tempNode;
        if (root == null)
            return null;
        nodeQuene.add(root);
        while (true){
            tempNode = nodeQuene.poll();
            if(tempNode.left!=null){
                nodeQuene.add(tempNode.left);
            }
            if(tempNode.right!=null){
                nodeQuene.add(tempNode.right);
            }
            valList.add(tempNode.val);
            if(nodeQuene.size()==0){
                break;
            }
        }
        return valList;
    }

}
