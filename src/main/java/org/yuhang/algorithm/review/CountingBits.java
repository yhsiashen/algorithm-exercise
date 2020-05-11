package org.yuhang.algorithm.review;

/**
 * 比特位计数 LC338
 */
public class CountingBits {

    public int[] countBits(int num) {
       if(num == 0) return new int[]{0};
       if(num == 1) return new int[]{0,1};
       if(num == 2) return new int[]{0,1,1};
       if(num == 3) return new int[]{0,1,1,2};
       int[] res = new int[num+1];
       res[0] = 0;
       res[1] = 1;
       res[2] = 1;
       res[3] = 2;
       int level = 8;
       for (int i = 4; i < num+1; i++) {
            if(i == level){
                level *= 2;
            }
           res[i] = res[i-level/2]+1;
       }
       return res;
    }

    public int[] countBits1(int num){
        int[] res = new int[num+1];
        for (int i = 1; i < num+1; i++) {
            res[i] = res[i & (i-1)]+1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountingBits().countBits(9));
    }
}
