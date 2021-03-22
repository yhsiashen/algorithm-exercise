package org.yuhang.algorithm.review.new20200226;

public class StreamRank {


        private class TreeNode{
            int val;
            TreeNode left;
            TreeNode right;
            int smaller; //该节点左子树的总数目以及自身的数目
            public TreeNode(int val){
                this.val = val;
                this.smaller = 1;
            }
        }

        TreeNode root;//二叉树

        private void insertBST(int val){
            if(root == null){
                root = new TreeNode(val);
                return;
            }
            insert0(root,val);
        }
        private void insert0(TreeNode node,int val){
            if(node.val == val) {
                node.smaller++;
            }else if(node.val > val) {
                if(node.left == null){
                    node.left = new TreeNode(val);
                }else{
                    insert0(node.left, val);
                }
            }else {
                if(node.right == null){
                    node.right = new TreeNode(val);
                }else{
                    insert0(node.right,val);
                }
            }
        }

        private int getSmallerFromBST(int val){
            TreeNode node = root;
            int rank = 0;
            while(node!=null){
                if(node.val == val){
                    return rank+ node.smaller;
                }else if(node.val < val){
                    rank += node.smaller;
                    node = node.right;
                }else {
                    node = node.left;
                }
            }
            return rank;

        }

        public StreamRank() {

        }

        public void track(int x) {
            //维护BST
            insertBST(x);
        }

        public int getRankOfNumber(int x) {
            if(root == null) return 0;
            return getSmallerFromBST(x);
        }

    public static void main(String[] args) {
        StreamRank rank = new StreamRank();
    }

}
