package org.yuhang.algorithm.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 183周周赛
 */
public class ProblemWeeklyContest183 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int partSum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            list.add(nums[i]);
            partSum+=nums[i];
            if(partSum > sum/2) { break;}
        }

        return list;

    }

    /**
     * 模拟加法和减法的二进制运算过程
     * @param s
     * @return
     */
    public int numSteps(String s) {
        if(s.length() == 1) return 0;
         int res = 0;
         int len = s.length();
         char[] chrs = s.toCharArray();
         while (true){
             if(chrs[len-1] == '1'){//s为奇数,s=s+1
                 res++;
                 chrs[len-1] = '0';
                 int i = len-2;
                 while (i>=0 && chrs[i] != '0'){
                     chrs[i] = '0';
                     i--;
                 }
                 if(i>=0){
                     chrs[i] = '1';
                 }else{
                     char[] chrs1= new char[chrs.length+1];
                     System.arraycopy(chrs,0,chrs1,1,chrs.length);
                     chrs = chrs1;
                     chrs[0] = '1';
                     len++;
                 }

             }else{//s为偶数,s=s/2
                 res++;
                 int i = len-1;
                 boolean isOne = true;
                 while (i>=1){
                     chrs[i] = chrs[i-1];
                     if( i!=len-1 && chrs[i] == '1') isOne = false;
                     i--;
                 }
                 chrs[0] = '0';
                 if(isOne) break;
             }
         }

         return res;
    }

    /**
     * 找规律且不需要完全模拟运算过程
     * @param s
     * @return
     */
    public int numSteps1(String s) {
        int idx = s.length() -1;
        char[] chs = s.toCharArray();
        int ans = 0;
        while (idx > 0){//第一位不需要计算
            if(chs[idx] == '0'){//s为偶数的情况，直接计算一次移位运算，结果+1，并将索引值-1
                ans++;
                idx--;
            }else{
                ans++;//s为奇数的情况，需要先加1，得到一个偶数后再计算移位次数
                while (idx >=0 && chs[idx] == '1'){
                    ans++;
                    idx--;
                }
                if(idx > 0){
                    chs[idx] = '1';
                }
            }
        }
        return ans;
    }


    /**
     * 贪心算法+排序数组
     * @param a
     * @param b
     * @param c
     * @return
     */
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
        if(a>0)priorityQueue.offer(new int[]{0,a});
        if(b>0)priorityQueue.offer(new int[]{1,b});
        if(c>0)priorityQueue.offer(new int[]{2,c});
        StringBuilder res = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            int[] first = priorityQueue.poll();//取出次数最多的字母
            if(res.length() >=2 && (char)(first[0]+'a') == res.charAt(res.length()-1)
                    && (char)(first[0]+'a') == res.charAt(res.length()-2)){//如果追加的字母与之前的结果组成了3个相同的连续字母，则此次取第二多的字母加入
                if(!priorityQueue.isEmpty()) {
                    int[] sec = priorityQueue.poll();
                    res.append((char) (sec[0] + 'a'));
                    sec[1] -= 1;
                    if(sec[1] > 0) priorityQueue.offer(sec);
                }else{//如果没有第二个字母了，则直接结束循环
                    break;
                }

            }else{//将字母加入结果中
                res.append((char)(first[0]+'a'));
                first[1] -= 1;
            }

            if(first[1] > 0) priorityQueue.offer(first);

        }
        return res.toString();
    }

    class Mychar{
        char ch;
        int count;
        public Mychar(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    /**
     * 贪心算法+排序数组
     * @param a
     * @param b
     * @param c
     * @return
     */
    public String longestDiverseString1(int a, int b, int c) {
        Mychar[] counts = new Mychar[]{
            new Mychar('a',a),
            new Mychar('b',b),
            new Mychar('c',c),
        };
        StringBuilder res = new StringBuilder();
        while (true){
            Arrays.sort(counts,((o1, o2) -> o2.count-o1.count));//按次数从大到小排序
            if(res.length() >= 2 && counts[0].ch == res.charAt(res.length()-1)
                    && counts[0].ch == res.charAt(res.length()-2)){
                if(counts[1].count-- > 0){
                    res.append(counts[1].ch);
                }else{
                    break;
                }
            }

            if(counts[0].count-- > 0){
                res.append(counts[0].ch);
            }else{
                break;
            }

        }
        return res.toString();
    }


    public static void main(String[] args) {
        ProblemWeeklyContest183 p = new ProblemWeeklyContest183();
//        System.out.println(p.longestDiverseString(1,1,7));
        System.out.println(p.numSteps1("1101"));
    }





    }
