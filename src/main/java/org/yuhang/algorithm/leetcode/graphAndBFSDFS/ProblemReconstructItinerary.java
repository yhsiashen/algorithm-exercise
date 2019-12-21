package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.*;

/**
 * 重新安排行程 LC332
 * @tag:DFS
 */
public class ProblemReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        Map<String,Queue<String>> graph = new HashMap<>();//用map表示行程图，key为机场，value为key相邻的机场集合
        for (List<String> ticket : tickets){
            //将行程关联关系组成一个图放入graph中,优先队列能将邻接机场按String字典排序,所以可以不用List
            Queue nbr = graph.computeIfAbsent(ticket.get(0),k -> new PriorityQueue<>());
            nbr.offer(ticket.get(1));
        }
//        graph.values().forEach(x->x.sort(String::compareTo));//图中每个顶点的边按字符串升序排序
        visitByStack(graph,"JFK",res);//从JFK机场开始，深度优先搜索相邻机场
        return res;

    }

    /**
     * 深度优先搜索递归版，逆序插入结果集中
     * @param graph
     * @param src
     * @param res
     */
    private void visitByRecursion(Map<String, Queue<String>> graph, String src, List<String> res) {
        Queue<String> nbr = graph.get(src);
        while (nbr!=null && nbr.size()>0){
            String dest = nbr.poll();
            visitByRecursion(graph,dest,res);
        }
        res.add(0,src);
    }

    /**
     * 深度优先搜索非递归版，用栈保存调用关系
     * @param graph
     * @param src
     * @param res
     */
    private void visitByStack(Map<String, Queue<String>> graph, String src, List<String> res){
        Stack<String> stack = new Stack<>();
        stack.push(src);
        while (!stack.isEmpty()) {
            Queue<String> nbr;
            while ((nbr = graph.get(stack.peek()))!=null && nbr.size()>0){
                stack.push(nbr.poll());
            }
            res.add(0,stack.pop());
        }
    }


    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ticket = new ArrayList<>();
//        String[][] t = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        ticket.add("JFK");
        ticket.add("KUL");
        tickets.add(ticket);
        ticket = new ArrayList<>();
        ticket.add("JFK");
        ticket.add("NRT");
        tickets.add(ticket);
        ticket = new ArrayList<>();
        ticket.add("NRT");
        ticket.add("JFK");
        tickets.add(ticket);
//        ticket = new ArrayList<>();
//        ticket.add("ATL");
//        ticket.add("JFK");
//        tickets.add(ticket);
//        ticket = new ArrayList<>();
//        ticket.add("ATL");
//        ticket.add("SFO");
        new ProblemReconstructItinerary().findItinerary(tickets);
    }
}
