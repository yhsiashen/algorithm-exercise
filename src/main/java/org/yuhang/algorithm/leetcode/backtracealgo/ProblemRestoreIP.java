package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.ArrayList;
import java.util.List;

/**
 * 通过给定的字符串复原所有可能的ip地址 LC93
 * @tag:回溯算法
 */
public class ProblemRestoreIP {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() == 0) return res;
        List<String> tmp = new ArrayList<>();
        backtrace(res,tmp,s);
        return res;
    }

    private void backtrace(List<String> res,List<String> tmp,String s){
        if("".equals(s) && tmp.size() == 4){//s遍历完毕且tmp中已有4个满足要求的字符串时得到一个结果
            StringBuilder ip = new StringBuilder();
            for(String str:tmp){
               ip.append(str);
               ip.append(".");
            }
            res.add(ip.substring(0,ip.length()-1));
            return;
        }
        if(s.length() > 0 && tmp.size()==4) return; //剪枝

            for (int i = 1; i <= 3; i++) { //每次遍历找长度为1~3的子串
                if (i <= s.length() && Integer.parseInt(s.substring(0, i)) <= 255 && Integer.parseInt(s.substring(0, i)) >= 0
                        ) {//不满足ip字段的范围时，剪枝
                    if(!(i>1 && s.substring(0,1).equals("0"))) continue; //当字符串长度大于1位，且第一位为0时，剪枝
                    tmp.add(s.substring(0, i));
                    backtrace(res, tmp, s.substring(i)); //递归找下一个满足的ip串
                    tmp.remove(tmp.size() - 1); //回溯移除最新加入的串
                }
            }

    }

    public static void main(String[] args) {
        new  ProblemRestoreIP().restoreIpAddresses("010010");
    }
}
