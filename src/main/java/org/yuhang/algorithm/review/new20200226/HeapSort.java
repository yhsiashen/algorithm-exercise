package org.yuhang.algorithm.review.new20200226;

/**
 * heap sort
 * heap:是一颗完全二叉树，每个节点的值大于(或小于)其叶子节点的值，
 *      完全二叉树可以用数组表示，索引为x的节点的叶子节点为x*2+1和x*2+2
 *
 */
public class HeapSort {

    int[] nums;//数组
    int n;//数组大小

    public HeapSort(int[] vals){
        nums = vals;
        n = vals.length;
        initHeap(nums,n);
    }

    private void initHeap(int[] array,int n){
       for (int i = n/2 -1; i >=0 ; i--) {
           shiftDown(array, n, i);
       }
    }

    /**
     * 从最后一个非叶子节点开始，比较节点与其两个孩子节点的值，选最大的交换到父节点
     */
    private void shiftDown(int[] array,int n, int j){
        while (true){
            int maxPos = j;
            if(j*2+1 < n && array[maxPos] < array[j*2+1]) maxPos = j*2+1;
            if(j*2+2 < n && array[maxPos] < array[j*2+2]) maxPos = j*2+2;
            if(maxPos == j) break;//当没有发生位置交换时，表示父节点元素为最大，退出循环
            swap(array,maxPos,j);
            j = maxPos;
        }
    }
    private void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void sort(int[] array){
        //每次将堆顶元素与数组最后一个元素交换，然后维护堆
        int k = n-1;
        while (k > 1) {
            swap(array, 0, k);
            k--;
            shiftDown(array, k, 0);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,3,4,7,8,2};
        HeapSort heapSort = new HeapSort(nums);
        heapSort.sort(nums);
        for(int n:nums){
            System.out.println(n);
        }
    }

}
