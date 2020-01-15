package org.yuhang.algorithm.leetcode.unionfind;

public class UnionFind {

    private int count;//记录连通分量

    private int[] parent;//x节点得父节点是parent[x]，记录各节点的父节点

    private int[] size;//记录每棵树包含的节点数量

    public UnionFind(int n){
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * 将p和q节点连通,即他们的父节点为同一个
     * @param p
     * @param q
     */
    public void union(int p,int q){
       int rootP = find(p);
       int rootQ = find(q);
       if(rootP == rootQ) return;
//       parent[rootP] = rootQ; //将p的父节点指向q的父节点
       if(size[rootP] > size[rootQ]) {// 平衡性优化:将小size的树接到大size的树下
           parent[rootQ] = rootP;
           size[rootP] += size[rootQ];
       }else{
           parent[rootP] = rootQ;
           size[rootQ] += size[rootP];
       }
       count--;//连通分量-1
    }

    /**
     * 返回两节点是否连通
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    /**
     * 返回节点的根节点
     * @param p
     * @return
     */
    public int find(int p) {
        while (parent[p] != p){
            p = parent[parent[p]];//路径优化
        }
        return p;
    }

    /**
     * 返回图中有多少连通分量
     * @return
     */
    public int count(){
        return count;
    }
}
