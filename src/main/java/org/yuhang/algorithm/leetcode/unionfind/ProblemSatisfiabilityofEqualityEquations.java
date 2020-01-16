package org.yuhang.algorithm.leetcode.unionfind;

/**
 * 等式方程的可满足性 LC990
 */
public class ProblemSatisfiabilityofEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);//只有小写字母
        for(String equation:equations){
            if(equation.charAt(1) == '='){
                uf.union(equation.charAt(0)-'a',equation.charAt(3)-'a');
            }
        }

        for(String equation:equations){
            if(equation.charAt(1) == '!'){
                if(uf.connected(equation.charAt(0)-'a',equation.charAt(3)-'a')) return false;
            }
        }
        return true;
    }
}
