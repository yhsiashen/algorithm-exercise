package org.yuhang.algorithm.interview;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * 最小的k个数
 */
public class ProblemLeastNumbers {

    /**
     * 堆 O(nlogk)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k==0) return new int[]{};
        Queue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int num:arr){
            queue.offer(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        int[] res = new int[k];
        int i =0;
        while (!queue.isEmpty()) res[i++] = queue.poll();
        return res;
    }

    /**
     * 快速选择(快排思想) O(n)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if(arr.length ==0 || k==0) return new int[]{};
        return quickSearch1(arr,0,arr.length-1,k-1);
    }

    /**
     * 双指针分数组
     * @param arr
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int[] quickSearch(int[] arr, int start, int end, int k) {
        if(start<=end) {
            int v = arr[start];
            int i = start, j = end + 1;
            while (true) {
                while (++i <= end && arr[i] < v);
                while (--j >= start && arr[j] > v);
                if (i >= j) {
                    break;
                }
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
            arr[start] = arr[j];
            arr[j] = v;

            if (j == k) return Arrays.copyOf(arr, j + 1);
            return j > k ? quickSearch(arr, start, j - 1, k) : quickSearch(arr, j + 1, end, k);
        }
        return null;
    }


    /**
     * 单指针分数组
     * @param arr
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int[] quickSearch1(int[] arr, int start, int end, int k) {
            int j =partition(arr,start,end);
            if (j == k) return Arrays.copyOf(arr, j + 1);
            return j > k ? quickSearch1(arr, start, j - 1, k) : quickSearch1(arr, j + 1, end, k);
    }

    private static Random random = new Random(System.currentTimeMillis());

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];//选择基准元素(第一个为基准元素，某些极端案例时间复杂度较大)

        if (right > left) {//选择随机基准元素(利用Random随机生成一个[left,right]区间内的索引)
            int randompivot = left + 1 + random.nextInt(right - left);
            swap(nums, left, randompivot);
        }

        int j = left;//表示最后一个比基准元素小的元素
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        //[0,0,1,1,1,3,2,4,1,5,2,7,1,5,2,7,1,8,5,2,10,2,12,7,6,15,2,15,8,6,22,2,8,7,3,18,2,22,10,9,7,6,32,8,9,12,10,20,16,28,10,17,11,22,19,17,12,44,13,36,31,22,19,52,19,56,58,19,26,23,27,26,49,27,33]
        int[] arr = new int[]{0,1,1,1,4,5,3,7,7,8,10,2,7,8,0,5,2,16,12,1,19,15,5,18,2,2,22,15,8,22,17,6,22,6,22,26,32,8,10,11,2,26,9,12,9,7,28,33,20,7,2,17,44,3,52,27,2,23,19,56,56,58,36,31,1,19,19,6,65,49,27,63,29,1,69,47,56,61,40,43,10,71,60,66,42,44,10,12,83,69,73,2,65,93,92,47,35,39,13,75};
        new ProblemLeastNumbers().getLeastNumbers1(arr,75);
//        Arrays.sort(arr);
//        for(int i:arr){
//            System.out.print(i+" ");
//        }
    }


}
