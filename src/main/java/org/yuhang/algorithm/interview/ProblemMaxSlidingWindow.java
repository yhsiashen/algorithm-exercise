package org.yuhang.algorithm.interview;

import java.util.*;

/**
 * 滑动窗口的最大值
 */
public class ProblemMaxSlidingWindow {

    /**
     * 暴力法 O(n*k)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0,right = k-1;
        ArrayList<Integer> list = new ArrayList<>();
        while (right < nums.length){
            list.add(calMax(nums,left++,right++));
        }
        int[] res = new int[list.size()];
        int count = 0;
        for(int i:list) res[count++] = i;
        return res;


    }

    private int calMax(int[] nums, int i, int j) {
        int res = Integer.MIN_VALUE;
        for (int k = i; k <=j ; k++) {
            res = Math.max(res, nums[k]);
        }
        return res;
    }

    /**
     * 单调递减的双端队列求最大值,最大值即为队列头元素,O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[]{};
        int left = 0, right = 0;
        Deque<Integer> deque = new LinkedList<>();//队列中存元素的索引(避免删除重复元素)
        ArrayList<Integer> list =  new ArrayList<>();

        while (right < nums.length){
            if(deque.isEmpty()){
                deque.offer(right);
            }else{
                while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]){//弹出队列中所有比它小的元素
                    deque.pollLast();
                }
                deque.offer(right);
            }

            if(right-left+1 == k){
                int maxIndex = deque.peek();
                list.add(nums[maxIndex]);//添加队头元素
                right++;
                if(left == maxIndex) deque.poll();//如果滑动窗口移除了最大元素，则弹出队列头元素
                left++;
            }else{
                right++;
            }
        }


        int[] res = new int[list.size()];
        int count = 0;
        for(int i:list) res[count++] = i;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(new ProblemMaxSlidingWindow().maxSlidingWindow1(nums,3));
    }


}
