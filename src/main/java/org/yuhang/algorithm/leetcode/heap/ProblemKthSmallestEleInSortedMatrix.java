package org.yuhang.algorithm.leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 有序矩阵中的第k小的元素 LC378
 */
public class ProblemKthSmallestEleInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int i = matrix.length-1; i >=0; i--) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if(queue.size() < k){
                    queue.add(matrix[i][j]);
                }else{

                    if(queue.peek() > matrix[i][j]){
                        queue.poll();
                        queue.add(matrix[i][j]);
                    }else {
                        continue;
                    }

                }
            }
        }

        return queue.peek();
    }

    /**
     * 二分查找
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest1(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][col - 1];
        while (left < right) {
            // 每次循环都保证第K小的数在left~right之间，当left==right，第k小的数就是left
            int mid = (left + right) / 2;
            // 找二维矩阵中<=mid的元素总个数
            int count = findNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                left = mid + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                right = mid;
            }
        }
        return right;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                count+=i+1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};
        System.out.println(new ProblemKthSmallestEleInSortedMatrix().kthSmallest1(matrix,8));
    }
}
