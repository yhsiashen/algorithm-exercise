package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

/**
 * 朋友圈 LC547
 */
public class ProblemFriendCircles {

    /**
     * DFS
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        /**
         使用一个visited数组, 依次判断每个朋友, 如果其未访问, 朋友圈数加1并对该节点进行dfs搜索标记所有访问到的节点
         **/
        boolean[] visited = new boolean[M.length];
        int ret = 0;
        for(int i = 0; i < M.length; ++i) {
            if(!visited[i]) {
                dfs(M, visited, i);
                ret++;
            }
        }
        return ret;
    }

    private void dfs(int[][] m, boolean[] visited, int i) {
        for(int j = 0; j < m.length; ++j) {
            if(m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, visited, j);
            }
        }
    }




    public static void main(String[] args) {
        int[][] M = {{1,1,0},
                     {1,1,0},
                     {0,0,1}};
        System.out.println(new ProblemFriendCircles().findCircleNum(M));
    }
}
