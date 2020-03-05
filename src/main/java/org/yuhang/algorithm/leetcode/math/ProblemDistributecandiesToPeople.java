package org.yuhang.algorithm.leetcode.math;

/**
 * 分糖果 LC1103
 */
public class ProblemDistributecandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {
         if(num_people == 0) return new int[]{};
         int[] ans = new int[num_people];
         ans[0] = 1;
         candies--;
         int count = 1;
         boolean start = true;
         while (candies > 0){
             for (int i = 0; i < ans.length; i++) {
                if(start){
                    start = false;
                }else{
                    if(count+1<=candies){
                        ans[i] += count+1;
                        candies -= count+1;
                        count++;
                    }else {
                        ans[i] += candies;
                        return ans;
                    }
                }
             }
         }
         return ans;
    }


    public int[] distributeCandies1(int candies, int num_people){
        int[] ans = new int[num_people];
        int count=0;
        while (candies >0 ){
            ans[count % num_people] = Math.min(count+1, candies);
            candies -= Math.min(count+1, candies);
            count++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res= new ProblemDistributecandiesToPeople().distributeCandies(60,4);
        for(int i:res){
            System.out.println(i);
        }
    }
}
