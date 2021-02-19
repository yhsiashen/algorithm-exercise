package org.yuhang.algorithm.review;

import java.util.Arrays;

/**
 * 分发糖果 LC135
 */
public class Candy {

    public int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0) return 0;
        int res = 0;
        int[] candys = new int[len];
        Arrays.fill(candys, 1);
        for (int i = 0; i < len-1; i++) {
            if(ratings[i] > ratings[i+1] && candys[i] <= candys[i+1]){
                candys[i] = candys[i+1]+1;
                int j = i-1;
                //从i-1往前循环，按得分重新分发糖果
                while (j>=0){
                    if(ratings[j] > ratings[j+1] && candys[j] <= candys[j+1]){
                        candys[j] = candys[j+1]+1;
                    }else if(ratings[j] < ratings[j+1] && candys[j] >= candys[j+1]){
                        candys[j+1] = candys[j]+1;
                    }
                    j--;
                }
            }else if(ratings[i] < ratings[i+1] && candys[i] >= candys[i+1]){
                candys[i+1]= candys[i]+1;
                int j = i-1;
                //从i-1往前循环，按得分重新分发糖果
                while (j>=0){
                    if(ratings[j] > ratings[j+1] && candys[j] <= candys[j+1]){
                        candys[j] = candys[j+1]+1;
                    }else if(ratings[j] < ratings[j+1] && candys[j] >= candys[j+1]){
                        candys[j+1] = candys[j]+1;
                    }
                    j--;
                }
            }
        }

        for (int candy:candys){
            res+=candy;
        }

        return res;
    }


    public int candy1(int[] ratings) {
        int len = ratings.length;
        if(len == 0) return 0;
        int[] candys = new int[len];
        candys[0] = 1;
        //从左往右遍历,如果后一个孩子得分比前一个高且后一个孩子目前的糖果比前一个孩子少，则给后一个孩子比前一个孩子多一个糖果;否则给1个糖果
        //这里选取后一个孩子与前一个孩子比较主要为了及时得到后一个孩子更新的糖果值
        for (int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i-1] && candys[i] <= ratings[i-1]){
                candys[i] = candys[i-1]+1;
            }else{
                candys[i] = 1;
            }
        }

        //从右往左遍历，如果后一个孩子得分比前一个高且后一个孩子目前的糖果比前一个孩子少，则给后一个孩子比前一个孩子多一个糖果
        for (int i = len-2; i >=0 ; i--) {
            if(ratings[i] > ratings[i+1] && candys[i] <= candys[i+1]){
                candys[i] = candys[i+1]+1;
            }
        }

        int res = 0;
        for(int candy:candys){
            res+=candy;
        }

        return res;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = {1,3,4,5,2};
        System.out.println(candy.candy(ratings));
    }
}
