package org.yuhang.algorithm.interview;

/**
 * 三维形体的表面积
 */
public class ProblemSurfaceAreaOf3dShapes {

    public int surfaceArea(int[][] grid) {
         if(grid.length == 0 || grid[0].length == 0) return 0;
         int res = 0;
         for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]!=0){
                    res += grid[i][j]*6;
                    res -= grid[i][j]>1?((grid[i][j]-1)*2):0; //减去叠加的重复面积
                    if(i+1 < grid.length)
                        res -= Math.min(grid[i][j],grid[i+1][j])*2;
                    if(j+1 < grid.length)
                        res -= Math.min(grid[i][j],grid[i][j+1])*2;
                }
            }
         }
         return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        System.out.println(new ProblemSurfaceAreaOf3dShapes().surfaceArea(grid));
    }
}
