package org.yuhang.algorithm.leetcode.slidingwindow;

import java.util.HashMap;

/**
 * 水果成篮 LC904
 */
public class ProblemFruitIntoBaskets {

    public int totalFruit(int[] tree) {

       int res = 0;
       int l = 0,r = 0;
       int type = 0;
       HashMap<Integer,Integer> map = new HashMap<>();
       while (r<tree.length){
           int fruit = tree[r];
           if(!map.containsKey(fruit)){
               map.put(fruit,1);
               type++;
           }else{
               map.put(fruit, map.get(fruit)+1);
           }

           while (type > 2){//两个篮子里水果种类满了
               int removeFruit = tree[l];
               int nums = map.get(removeFruit);
               if(nums == 1){
                   type--;
                   map.remove(removeFruit);
               }else{
                   map.put(removeFruit, nums-1);
               }
               l++;
           }
           r++;
           res = Math.max(res, r-l);
       }
       return res;
    }

    public static void main(String[] args) {
        int[] trees = {0,1,2,2};
        System.out.println(new ProblemFruitIntoBaskets().totalFruit(trees));
    }
}
