package org.yuhang.algorithm.leetcode.heap;

/**
 * 堆的建立，维护及堆排序(大顶堆)
 */
public class HeapSort {

    /**
     * 堆的定义
     */
    static class Heap {

        /**存储堆元素的数组，完全二叉树适合用数组存储
          *1.坐标为i的元素左子节点的坐标为i*2;右子节点的坐标为i*2+1。此表示法直观，但数组坐标从1开始,因此会'浪费'0位置
          *2.坐标为i的元素左子节点的坐标为i*2+1;右子节点的坐标为i*2+2。此表示法不会浪费0位置
         **/
        private int[] a;
        //堆中存储的最大的数据个数
        private int n;
        //堆中已存储的数据个数
        private int count;

        /**
         * Heap构造器
         * @param vals
         */
        public Heap(int[] vals) {
            n = vals.length-1;
            //0位置不存数据，则最多能堆化n个数据
            a = vals;
            count = 0;
            initHeap(a,n);
        }

        /**
         * 初始化堆方法一: 从非叶子节点开始,从上到下依次堆化
         * @param a,n
         */
        private void initHeap(int[] a, int n) {
            //从第一个非叶子节点开始，依次堆化
            for (int i = n/2-1; i >= 1; i--) {
                heapify(a, n, i);
            }
        }

        /**
         * 初始化堆方法二: 从数组第一个开始,一步步插入元素堆化
         * @param a
         * @param n
         */
        private void initHeap2(int[] a,int n){
            for (int i = 1; i <= n; i++) insert(a[i]);
        }


        /**
         * 将数组a中i位置的元素调整到堆中应在位置
         *
         * @param a
         */
        public void heapify(int[] a, int n, int i) {
            while (true) {
                int maxPos = i;
                if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
                if (i*2 + 1 <= n && a[maxPos] < a[i*2 + 1]) maxPos = i*2 + 1;
                if (maxPos == i) break;
                swapInt(a, i, maxPos);
                i = maxPos;
            }
        }


        /**
         * 堆中插入元素
         *
         * @param val
         */
        public void insert(int val) {
            if (count >= n) {
                throw new ArrayIndexOutOfBoundsException("heap capacity is full");
            }
            ++count;
            //新添加的节点先加入数组最后一位
            a[count] = val;
            int tmp = count;
            //不断比较节点和父节点大小,直到找到对应位置
            while (a[tmp] > a[tmp /2] && tmp /2 != 0) {
                swapInt(a, tmp, tmp /2);
                tmp = tmp /2;
            }
        }

        /**
         * 交换数组a的i,j俩index的值
         * @param a,i,j
         */
        private void swapInt(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        /**
         * 堆排序，将堆顶元素与堆尾元素互换位置，然后维护堆
         */
        public void heapSort(){
            int k = n;
            while (k>1){
                swapInt(a,1,k);
                --k;
                heapify(a,k,1);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,0,3,4,7,8,2};
        Heap heap = new Heap(a);
        heap.heapSort();
        for (int i:heap.a) {
            System.out.println(i);
        }

    }

}


