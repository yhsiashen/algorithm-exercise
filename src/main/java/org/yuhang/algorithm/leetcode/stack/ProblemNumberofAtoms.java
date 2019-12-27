package org.yuhang.algorithm.leetcode.stack;

import java.util.*;

/**
 * 原子的数量 LC726
 *
 */
public class ProblemNumberofAtoms {

    public String countOfAtoms(String formula) {
         StringBuilder res = new StringBuilder();
         Map<String,Integer> freqMap = new HashMap<>();
         Stack<Integer> freqStack = new Stack<>();
         Stack<String> atomStack = new Stack<>();
        for (int i = 0; i < formula.length(); i++) {
            int ch = formula.charAt(i);
            if(ch - 'A' >=0 && ch - 'A' < 26){ //ch为大写字母的情况
                int j = i;
                while (j+1 < formula.length() && (formula.charAt(j+1)-'a' >=0 && formula.charAt(j+1) -'a' < 26)){//找完整的元素名称,后面的小写字母
                    j++;
                }
                String atom = formula.substring(i,j+1);
                int freqs = 0;
                while (j+1<formula.length() && Character.isDigit(formula.charAt(j+1))){//找元素后面的数字，可能很大
                    j++;
                    freqs = freqs*10+(formula.charAt(j) - '0');
                }
                atomStack.push(atom);
                freqStack.push(freqs>0?freqs:1);
                i = j;
            }else if(ch == '('){
                atomStack.push(formula.substring(i,i+1));
            }else if(ch == ')'){
                int freqs = 0;//括号对中原子的频率
                while(i+1<formula.length() && Character.isDigit(formula.charAt(i+1))){
                    i++;
                    freqs = freqs*10+(formula.charAt(i)-'0');
                }
                freqs = freqs>0?freqs:1;
                Map<String,Integer> tmp = new HashMap<>();
                while (!atomStack.isEmpty() && !atomStack.peek().equals("(")){
                    String pop = atomStack.pop();
                    tmp.put(pop,tmp.getOrDefault(pop,0)+freqStack.pop()*freqs);
                }
                atomStack.pop(); // 弹出"("
                for(Map.Entry<String,Integer> entry: tmp.entrySet()){//重新将计算好的原子频率压入栈
                    atomStack.push(entry.getKey());
                    freqStack.push(entry.getValue());
                }
            }
        }

         while (!atomStack.isEmpty() && !freqStack.isEmpty()){
             String pop = atomStack.pop();
             freqMap.put(pop,freqMap.getOrDefault(pop,0)+freqStack.pop());
         }
        PriorityQueue<Map.Entry<String,Integer>> deque = new PriorityQueue<>(Comparator.comparing(Map.Entry::getKey));
         deque.addAll(freqMap.entrySet());
         while (!deque.isEmpty()){
             Map.Entry entry = deque.poll();
             res.append(entry.getKey());
             if((int)entry.getValue() != 1){
                 res.append((int)entry.getValue());
             }
         }

         return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ProblemNumberofAtoms().countOfAtoms("((HHe28Be26He)9)34"));
    }
}
