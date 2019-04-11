package org.yuhang.algorithm.leetcode.graph;



import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 有向带权图的表示以及Dijkstra算法
 */
public class DirectedWeightedGraph {

    /**顶点个数 */
    private int v;

    /**数组大小为顶点个数,数组的每个元素为一个链表,链表中存储与顶点相邻的边 */
    private LinkedList<Edge>[] adj;

    public DirectedWeightedGraph(int v){
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    /**
     * 向图中添加一条边(起始点，终点，权重)
     * @param sid
     * @param tid
     * @param weigth
     */
    public void addEdge(int sid,int tid,int weigth){
        adj[sid].add(new Edge(sid,tid,weigth));
    }



    /**
     * Dijkstra算法找出s到t的最短距离
     * @param s
     * @param t
     */
    public void findShortestPathByDijkstra(int s,int t){
        //用数组表示所有顶点距起点的距离类集合
        Vertex[] vertexes = new Vertex[this.v];
        //将距离初始化为最大
        for (int i = 0; i <v ; i++) {
           vertexes[i] = new Vertex(i,Integer.MAX_VALUE);
        }
        //用优先队列存储vertex
        PriorityQueue queue = new PriorityQueue(this.v, (o1, o2) -> o1.dist-o2.dist);
        //标记vertex是否进入过队列
        boolean[] inqueue = new boolean[this.v];
        //将s点距s点的距离初始化为0
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;

        while (!queue.isEmpty()){
            //poll出堆顶元素--表示此时距起点最近的顶点
            Vertex minVertex = queue.poll();
            if(minVertex.id == t) break; //最短路径产生了
            //遍历与堆顶元素邻接的所有边
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                 Edge edge = adj[minVertex.id].get(i); //与堆顶元素相连的某条边
                 Vertex nextVertex = vertexes[edge.tid]; //边的终点
                 //若minVertex加上路长小于nextVertex的dist，说明minVertex+edge.weigth是此时到nextVertex的最短路径
                 if(minVertex.dist + edge.weigth < nextVertex.dist){
                     nextVertex.dist = minVertex.dist+edge.weigth;
                     if(inqueue[nextVertex.id]){
                         queue.update(nextVertex);
                     }else{
                         queue.add(nextVertex);
                         inqueue[nextVertex.id] = true;
                     }
                 }
            }
        }
    }


    /**
     * 表示边的类
     */
    private class Edge{
        int sid; //边的起始顶点编号
        int tid; //边的终点顶点编号
        int weigth; //边的权重
        public Edge(int sid,int tid,int weigth){
            this.sid = sid;
            this.tid = tid;
            this.weigth = weigth;
        }
    }

    /**
     * 顶点定义，包含id和该顶点距起始点的距离
     */
    private static class Vertex{
        int id;
        int dist;
        public Vertex(int id,int  dist){
          this.id = id;
          this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Vertex)) return false;
            Vertex vertex = (Vertex) o;
            return id == vertex.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }


    /**
     * 小顶堆存储Vertex
     */
    private class PriorityQueue {

         /**数组存储堆中元素*/
         private Vertex[] element;

         /**堆的最大容量*/
         private int capacity;

         /**堆中元素的数目*/
         private int size = 0;

         /**比较器,定义Vertex比较规则*/
         private final Comparator<Vertex> comparator;

         public PriorityQueue(int capacity, Comparator<Vertex> comparator){
              this.capacity = capacity;
              this.element = new Vertex[capacity];
              this.comparator = comparator;
         }


        /**
         * 将vertex加入堆中
         * @param vertex
         */
         public void add(Vertex vertex){
            if(isFull() || vertex==null) return;
            int s = ++size;
            siftUp(s-1,vertex);
         }


        /**
         * 更新堆中vertex值
         * @param vertex
         */
         public void update(Vertex vertex){
            if(isEmpty() || vertex==null) return;
            //遍历数组找到要更新的vertex节点(id相等则认为是同一个vertex)
             int index=-1;
             for (int i = 0; i < size ; i++) {
                  if(vertex.equals(element[i])){
                      index = i;
                  }
             }
             //没找到要更新的vertex节点，直接返回
             if(index == -1) return;
             //分别向上/向下堆化此元素
             siftUp(index,vertex);
             siftDown(index,vertex);
         }

         /**
         * 取出堆顶元素
         * @return
         */
        public Vertex poll(){
            if(isEmpty()) return null;
            int s= --size;
             //取出堆顶元素
             Vertex minVertex = element[0];
             Vertex x = element[s];
             element[s] = null;
             if(s!=0) {
                 siftDown(0,x);
             }
              return minVertex;
        }

        /**
         * 将k位置空缺处添加元素，使之符合堆特性，往下
         */
        private void siftDown(int k,Vertex x){
            int half = size/2;
            while (k < half){
                int child = k*2+1;
                Vertex least = element[child]; //假设左子节点是最小的
                int right = child+1;
                //比较左右子节点谁更小,若右子节点更小,则将child置为右子节点
                if(right<size && comparator.compare(element[child],element[right]) >0 ){
                    least = element[child = right];
                }
                //若此时待堆化的元素x比c更小,则找到插入的点,退出循环
                if(comparator.compare(x,least) <= 0){
                    break;
                }
                //将最小节点值放到k位置
                element[k] = least;
                //将待堆化的元素位置指向child,继续循环
                k = child;
            }

            //循环到叶子节点或x元素比c更小时
            element[k] = x;
        }

        /**
         * 将k位置空缺处添加元素，使之符合堆特性，往上
         * @param k
         * @param vertex
         */
        private void siftUp(int k,Vertex vertex){
           while (k>0) {
               int parent = (k - 1) / 2;
               if (comparator.compare(vertex, element[parent]) >0){
                   break;
               }
               element[k] = element[parent];
               k = parent;
           }
           element[k] = vertex;
        }

        public boolean isEmpty(){
            return size==0;
        }

        public boolean isFull(){
            return size==capacity;
        }
    }

}
