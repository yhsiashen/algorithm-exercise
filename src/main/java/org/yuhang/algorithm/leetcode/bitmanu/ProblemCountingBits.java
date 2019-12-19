package org.yuhang.algorithm.leetcode.bitmanu;


/**
 * 比特位计数 LC338
 * @tag:位运算
 * @tag:动态规划
 */
public class ProblemCountingBits {

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
        int level = 2;
        for (int i = 4; i <=num ; i++) {
            int pre = (int)Math.pow(2,level);
            if(i<(pre<<1)) {
                res[i] = res[i - pre] + 1;
            }else {
                level++;
                i--;
            }
        }
        return res;
    }

    /**
     * 将最右的1置成0
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        for(int i = 1;i<= num;i++){  //注意要从1开始，0不满足
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new ProblemCountingBits().countBits(16);
        for (int i : res){
            System.out.print(i+" ");
        }
    }
}
