package org.yuhang.algorithm.review.new20200226;

import java.util.*;

/**
 * 婴儿名字
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
 *      synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 *
 * 输出：["John(27)","Chris(36)"]
 *
 * notes: names.length <= 100000
 *
 */
public class BabyNames {


    private class UnionFind{
        int[] parent;//连通分量
        int[] size;//每个树的集合大小
        public UnionFind(int n){
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {//初始化各个节点的父节点(他本身)，以及各个数的初始值
                parent[i] = i;
                size[i] = 1;
            }
        }

        private void union(int p,int q){
            int parentP = find(p);
            int parentQ = find(q);
            if(size[p] > size[q]){//小树挂在大树下
                parent[q] = parentP;
                size[p] += size[q];//大树的集合加上小树的集合
            }else{
                parent[p] = parentQ;
                size[q] += size[p];
            }
        }

        private int find(int x){
            while (parent[x]!=x){
                x = parent[x];
            }
            return x;
        }

    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        List<String> res =  new ArrayList<>();
        if(names.length == 0) return res.toArray(new String[]{});
        UnionFind uf = new UnionFind(100001);//
        HashMap<String,Integer> nameMap = new HashMap();//为每个名字赋给一个编号
        HashMap<String,Integer> nameFreqs = new HashMap<>();//名字->出现频率
        for (int i = 0; i < names.length; i++) {
            String name = names[i].substring(0, names[i].indexOf('('));
            int freqs = Integer.valueOf(names[i].substring(names[i].indexOf("(")+1, names[i].indexOf(")")));
            nameMap.put(name, i);
            nameFreqs.put(name,freqs);
        }

        for(String syn:synonyms) {//连接各名字编号
            String name1= syn.substring(syn.indexOf("(")+1, syn.indexOf(","));
            String name2= syn.substring(syn.indexOf(",")+1, syn.indexOf(")"));
            //连接俩名字,然后将俩名字出现频率相加，并去字典值较小的名字重新put到频率表中
            String smallerName = name1.compareTo(name2) < 0 ? name1:name2;//字典序小的名字
            String biggerName = name1.compareTo(name2) < 0 ? name2:name1;//字典序大的名字
            if(nameMap.containsKey(smallerName) && nameMap.containsKey(biggerName)){//连接两名字编号
                uf.union(nameMap.get(smallerName), nameMap.get(biggerName));
            }
            int freqs = nameFreqs.getOrDefault(smallerName,0)+nameFreqs.getOrDefault(biggerName,0);
            nameFreqs.put(smallerName, freqs);
            nameFreqs.remove(biggerName);
        }

        return res.toArray(new String[]{});
    }

    public String[] trulyMostPopular1(String[] names, String[] synonyms){
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();
        for (String name : names){     //统计频率
            int idx1 = name.indexOf('(');
            int idx2 = name.indexOf(')');
            int frequency = Integer.valueOf(name.substring(idx1 + 1, idx2));
            map.put(name.substring(0, idx1), frequency);
        }
        for (String pair : synonyms){  //union同义词
            int idx = pair.indexOf(',');
            String name1 = pair.substring(1, idx);
            String name2 = pair.substring(idx + 1, pair.length() - 1);
            while (unionMap.containsKey(name1)){   //找name1祖宗
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)){   //找name2祖宗
                name2 = unionMap.get(name2);
            }
            if(!name1.equals(name2)){   //祖宗不同，要合并并计算合并后的频率
                int frequency = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);    //出现次数是两者之和
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;//小名
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;//大名
                unionMap.put(nickName, trulyName);//将小名做大名的祖宗
                map.remove(nickName);//更新一下数据
                map.put(trulyName, frequency);//把小名目前的频率更新
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String name : map.keySet()) {
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            sb.append(map.get(name));
            sb.append(')');
            res[index++] = sb.toString();
        }
        return res;
    }


    public static void main(String[] args) {
        String[] names = {"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"};
        String[] synonyms ={"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"};
        new BabyNames().trulyMostPopular(names, synonyms);
    }


}
