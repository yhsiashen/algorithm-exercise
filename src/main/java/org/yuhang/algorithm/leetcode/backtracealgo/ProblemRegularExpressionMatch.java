package org.yuhang.algorithm.leetcode.backtracealgo;


/**
 * 正则表达式匹配  回溯算法 10
 */
public class ProblemRegularExpressionMatch {

    boolean matched = false;
    int slength = 0;
    int plength = 0;

    public boolean isMatch(String s, String p) {
       if(p == null || "".equals(p)){
           return false;
       }

       char[] sChars = s.toCharArray();
       char[] pChars = p.toCharArray();

       slength = sChars.length;
       plength = pChars.length;

       match(0,0,sChars,pChars);

       return matched;
    }


    private void match(int si,int pi,char[] sChars,char[] pChars){
        if(matched) return;  //若已匹配，则返回
        if(pi == plength && si == slength)  matched = true; //正则表达式和文本串都结束，则匹配

        if(pChars[pi] == '*') { //表示匹配0或多个字符它前面的字符,如a*可以匹配aaaa,但不能匹配ab
            for(int k = 0; k <= slength-si;k++){
                match(si+k,pi-1,sChars,pChars);
            }
        }else if(pChars[pi] == '.'){
            match(si,pi+1,sChars,pChars);
            match(si+1,pi+1,sChars,pChars);
        }else if(si < slength && pChars[pi] == sChars[si]){
            match(si+1,pi+1,sChars,pChars);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ProblemRegularExpressionMatch().isMatch("mississssspppi","mis*is*p*."));
    }
}
