package org.yuhang.algorithm.leetcode.unionfind;


/**
 * 连通网络的操作次数 LC1319
 */
public class ProblemNumberofOperationsToMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int redunNum = 0;
        for(int[] pair:connections){
            if(uf.connected(pair[0],pair[1])){//若这两个点之前已连通，则这条线是多余的，可以供给连接其他点
               redunNum++;
            }else {
                uf.union(pair[0], pair[1]);
            }
        }

        if(redunNum >= uf.count()-1){
            return uf.count()-1;
        }else{
            return -1;
        }
    }
}
