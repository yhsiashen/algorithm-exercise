package org.yuhang.algorithm.leetcode.unionfind;

/**
 * 朋友圈 LC547
 */
public class ProblemFriendCircles {

    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if(M[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        return uf.count();
    }

}
