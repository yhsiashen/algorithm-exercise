package org.yuhang.algorithm.contest;

import java.util.*;

/**
 * 184周周赛
 */
public class ProblemWeeklyContest184 {

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(j!=i && words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    public int[] processQueries(int[] queries, int m) {
         int[] res = new int[queries.length];
         ArrayList<Integer> list = new ArrayList<>();
         for (int i = 1; i <=m ; i++) {
            list.add(i);
         }
        for (int i = 0; i < queries.length; i++) {
            int index = list.indexOf(queries[i]);
            res[i] = index;
            list.remove(index);
            list.add(0,queries[i]);
        }
         return res;

    }

    public String entityParser(String text) {
        HashMap<String,String> map = new HashMap<>();
        map.put("&quot;","\"");
        map.put("&apos;","'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < text.length();) {
            if(text.charAt(i) == '&'){
                int j = i;
                while (j<text.length() && text.charAt(j)!=';'){
                    j++;
                }
                String s = text.substring(i,++j);
                if(map.containsKey(s)) {
                    res.append(map.get(s));
                }else{
                    res.append(s);
                }
                i = j;
            }else{
                res.append(text.charAt(i));
                i++;
            }
        }
        return res.toString();


    }

    public static void main(String[] args) {
//        int[] qu = {4,1,2,2};
//        int[] res = new ProblemWeeklyContest184().processQueries(qu,4);
//        for(int i:res) System.out.println(i);
        System.out.println(new ProblemWeeklyContest184().entityParser("and I quote: &quot;...&quot;"));
    }

}
