package org.yuhang.algorithm.leetcode.graphAndBFSDFS;


import java.util.*;

/**
 * 除法求值 LC399
 * @tag:图
 */
public class ProblemEvaluatedivision {

    //表示图中的每个顶点
    class Node{
        String nodeName;
        Map<Node,Double> edge; //node的边，用hash表表示，可能存在多个

        public Node(String nodeName) {
            this.nodeName = nodeName;
            this.edge = new HashMap<>();
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Map<String,Node> graph = new HashMap<>();

        for (int i = 0; i < values.length ; i++) { //遍历表达式,将关系放入图中
             String a = equations.get(i).get(0);
             String b = equations.get(i).get(1);
             graph.putIfAbsent(a,new Node(a));
             graph.putIfAbsent(b,new Node(b));
             Node aNode = graph.get(a);
             Node bNode = graph.get(b);
             aNode.edge.put(bNode,values[i]);
             bNode.edge.put(aNode,1/values[i]);
        }
        int i = 0;

        for (List<String> query:queries){
            Set<String> visited = new HashSet<>();
            String start  = query.get(0);
            String end = query.get(1);
            if(!graph.containsKey(start) || !graph.containsKey(end)) res[i] = -1.0;
            else res[i] = dfs(graph.get(start),graph.get(end),visited,1.0);
            i++;
        }
        return res;

    }


    /**
     * coef为遍历过程中间的乘积结果，当在当前节点得邻接关系中找到end节点时，返回res结果，如果遍历完了还没找到，则返回-1
     *
     */
    private double dfs(Node start, Node end, Set<String> visited, double coef) {
        visited.add(start.nodeName);
        if(start.edge.containsKey(end)){
            return coef * start.edge.get(end);
        }
        for (Map.Entry<Node,Double> entry: start.edge.entrySet()){
            if(!visited.contains(entry.getKey().nodeName)){
                double res = dfs(entry.getKey(),end,visited,coef * entry.getValue());
                if(res!=-1.0){
                    return res;
                }
            }
        }
        return -1.0;

    }


    /**
     * 自己想法的错误示范！！！！！
     *
     */
    private double dfs1(Map<String, Node> graph, String start, String end, Set<String> visited) {
        visited.add(start);
        Node node = graph.get(start);
        for (Map.Entry<Node,Double> entry: node.edge.entrySet()){
            if(!visited.contains(entry.getKey().nodeName)) {
                Node neighbour = entry.getKey();
                Double multi = entry.getValue();
                if (neighbour.nodeName.equals(end)) {
                    return multi;
                }
                return multi * dfs1(graph, neighbour.nodeName, end, visited);
            }

        }
        return -1.0;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equ1 = new ArrayList<>();
        equ1.add("a");
        equ1.add("b");
        equations.add(equ1);
        List<String> equ2 = new ArrayList<>();
        equ2.add("b");
        equ2.add("c");
        equations.add(equ2);

        List<List<String>> querys = new ArrayList<>();
        List<String> qu1 = new ArrayList<>();
        qu1.add("a");
        qu1.add("a");
        querys.add(qu1);

        new ProblemEvaluatedivision().calcEquation(equations,new double[]{2.0,3.0},querys);
    }
}
