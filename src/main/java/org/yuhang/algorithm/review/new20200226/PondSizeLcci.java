package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.leetcode.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 水域大小
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 *
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 */
public class PondSizeLcci {

    private int m;
    private int n;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

    public int[] pondSizes(int[][] land) {
        List<Integer> ponds = new ArrayList<>();
        m = land.length;
        n = land[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(land[i][j] == 0){
                    ponds.add(dfs(land,i,j));
                }
            }
        }

        int[] res = new int[ponds.size()];
        int i = 0;
        for(int pond:ponds){
            res[i++] = pond;
        }
        Arrays.sort(res);
        return res;
    }

    /**
     * 遍历并返回区域内水域的大小
     * @return
     */
    private int dfs(int[][] land,int i,int j){
        if(i < 0 || i >= m || j < 0 || j>=n || land[i][j] != 0 ){
            return 0;
        }
        land[i][j] = 1;
        int res = 1;
        for(int[] dir:dirs){
            res+=dfs(land, i+dir[0],j+dir[1]);
        }
        return res;
    }
}
