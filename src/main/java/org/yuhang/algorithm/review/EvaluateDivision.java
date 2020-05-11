package org.yuhang.algorithm.review;

import java.util.*;

/**
 * 除法求值 LC399
 */
public class EvaluateDivision {


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> pair = equations.get(i);
            // a/b = 3.0可以表示为两种关系: a/b=3.0 or b/a = 1/3
            HashMap<String,Double> neighbors1 = graph.getOrDefault(pair.get(0),new HashMap<>());
            neighbors1.put(pair.get(1),values[i]);
            graph.put(pair.get(0),neighbors1);

            HashMap<String,Double>  neighbors2 = graph.getOrDefault(pair.get(1),new HashMap<>());
            neighbors2.put(pair.get(0),1/values[i]);
            graph.put(pair.get(1),neighbors2);
        }

        double[] res = new double[queries.size()];
        int cnt=  0;

        for(List<String> query:queries){
            Set<String> visited = new HashSet<>();
            String dividend = query.get(0);
            String divisor = query.get(1);
            if(graph.containsKey(dividend) || graph.containsKey(divisor)){
                res[cnt++] = dfs(graph,dividend,divisor,visited,1.0);
            }else{
                res[cnt++] = -1.0;
            }
        }

        return res;
    }

    private double dfs(HashMap<String,HashMap<String,Double>> graph, String start,String target,Set<String> visited,double before){
        if(visited.contains(start)) return -1.0;
        visited.add(start);
        //所有邻居
        HashMap<String,Double> neighbors = graph.getOrDefault(start,new HashMap<>());//getorDefault可以简化空处理

        //遍历所有邻居
        for(String node:neighbors.keySet()){
            if(node.equals(target)){//找到目标节点
                return before*neighbors.get(node);
            }else{
               double res = dfs(graph,node,target,visited,before*neighbors.get(node));
               if(res!=-1.0){
                   return res;
               }
            }

        }
        return -1.0;
    }
}
