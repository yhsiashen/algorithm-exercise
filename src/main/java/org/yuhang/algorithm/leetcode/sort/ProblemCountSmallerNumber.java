package org.yuhang.algorithm.leetcode.sort;


import java.util.ArrayList;
import java.util.List;

/**
 * 计算元素右侧小于当前元素的个数 LC315
 * @tag:排序应用
 * @tag:二叉树
 */
public class ProblemCountSmallerNumber {

    public class TreeNode{
        int val;
        int leftcount; //左子树节点的数量
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 构建一颗二叉搜索树
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        TreeNode root = null;
        int[] ress = new int[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
            root = insertNode(root,nums[i],ress,i);
        }
        for (int i = 0; i < nums.length ; i++) {
            res.add(ress[i]);
        }
        return res;

    }

    private TreeNode insertNode(TreeNode root, int val, int[] ress, int res_index) {
        if(root == null){
            root = new TreeNode(val);
        }else if(val < root.val){
            root.leftcount +=1;
            root.left = insertNode(root.left,val,ress,res_index);
        }else if(val > root.val){
            ress[res_index]+=root.leftcount+1;
            root.right = insertNode(root.right,val,ress,res_index);
        }
        return root;
    }



    private int[] temp;
    private int[] counter;
    private int[] indexes;


    /**
     * 归并排序应用
     * @param nums
     * @return
     */
    public List<Integer> countSmaller1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        temp = new int[len];
        counter = new int[len];
        indexes = new int[len];//构建索引数组
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1);
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    /**
     * 将数组做归并降序，排序过程中计算比元素小的数量
     * @param nums
     * @param l
     * @param r
     */
    private void mergeAndCountSmaller(int[] nums, int l, int r) {
        if (l == r) {
            // 数组只有一个元素的时候，没有比较，不统计
            return;
        }
        int mid = l + (r - l) / 2;
        mergeAndCountSmaller(nums, l, mid);
        mergeAndCountSmaller(nums, mid + 1, r);
        mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
    }

    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
        int i = l,j = mid+1;
        int k = l;
        while (i<=mid && j<=r){ //两边数组都还有数时
            if(nums[indexes[i]]<=nums[indexes[j]]){
                temp[k++] = indexes[j++];//右侧出列
            }else {
                counter[indexes[i]] += r-j+1;//左侧出列时，左侧比出列元素小的数之前归并排序时已计算，
                                             //右侧[j,r]区间内的所有元素都比出列的值小，用索引坐标计算
                temp[k++] = indexes[i++];
            }
        }

        while (i<=mid){
            temp[k++] = indexes[i++];
        }

        while (j<=r){
            temp[k++] = indexes[j++];
        }
        System.arraycopy(temp,l,indexes,l,r-l+1);
    }


    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        List<Integer> list = new ProblemCountSmallerNumber().countSmaller1(nums);
        for (int i:list){
            System.out.println(i);
        }
    }
}
