package com.chinalife.springmvc.algorithm.rowtooffer;

/** 替换空格
 * Created by yuhang on 2018/3/25.
 */
public class Problem2 {
    public static String replaceSpace(StringBuffer str) {
         for(int i = 0;i<str.length();i++){
             if(" ".equals(str.substring(i,i+1))){
                 str.replace(i,i+1,"%20");
             }
         }
          return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("ABCBCA C B");
//        System.out.println(str.length());
        System.out.println(Problem2.replaceSpace(str));
    }
}
