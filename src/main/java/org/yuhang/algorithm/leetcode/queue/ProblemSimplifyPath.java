package org.yuhang.algorithm.leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Unix系统风格路径简化 71
 */
public class ProblemSimplifyPath {

    public String simplifyPath(String path) {
       String[] tokens = path.split("/");
       Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("")){
                continue;
            }else if(tokens[i].equals(".")){
                continue;
            }else if(tokens[i].equals("..")){
                if(deque.isEmpty()){
                    continue;
                }else{
                    deque.pollLast();
                }
            }else {
                deque.offer(tokens[i]);
            }
        }

        StringBuilder res = new StringBuilder("/");
        while (!deque.isEmpty()){
            res.append(deque.poll());
            res.append("/");
        }
        String apath =  res.toString().substring(0,res.length()-1);
        return apath.length()==0?"/":apath;
    }

    public static void main(String[] args) {
        String path = "/a/../../b/../c//.//";
        ProblemSimplifyPath p = new ProblemSimplifyPath();
        p.simplifyPath(path);
    }
}
