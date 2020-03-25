package org.yuhang.algorithm.interview;

/**
 * 机器人的运动范围
 */
public class ProblemMovingCount {

    int res;

    public int movingCount(int m, int n, int k) {
       int[][] graph = new int[m][n];
       for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sumx = 0;
                int sumy = 0;
                int x=i,y=j;
                while (x>0){
                    sumx+=x%10;
                    x/=10;
                }
                while (y>0){
                    sumy+=y%10;
                    y/=10;
                }
                if(sumx+sumy>k){
                    graph[i][j] = -1;
                }
            }
       }
       boolean[][] visited = new boolean[m][n];
       dfs(graph,visited,0,0);
       return res;
    }

    private void dfs(int[][] graph, boolean[][] visited, int i, int j) {
        if(i<0||i>=graph.length||j<0||j>=graph[0].length) return;
        if(!visited[i][j] && graph[i][j]!=-1){
            res++;
            graph[i][j] = 1;
            visited[i][j] = true;
            dfs(graph,visited,i+1,j);
            dfs(graph,visited,i-1,j);
            dfs(graph,visited,i,j-1);
            dfs(graph,visited,i,j+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ProblemMovingCount().movingCount(3,1,0));
    }
}
