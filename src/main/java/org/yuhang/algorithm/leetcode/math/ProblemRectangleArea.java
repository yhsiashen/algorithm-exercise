package org.yuhang.algorithm.leetcode.math;


/**
 * 计算矩形相交部分的面积
 */
public class ProblemRectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1,x2,y1,y2,s;
        if(C<=E || G<=A || D<=F || H<=B){ //两个矩形没有相交部分
            s = 0;
        }else{
             x1 = Math.max(A, E);
             x2 = Math.min(C, G);

             y1 = Math.max(B, F);
             y2 = Math.min(D, H);
             s = (x2-x1) * (y2-y1);
        }
        return (C-A) * (D-B) + (G-E) * (H-F) - s;
    }
}
