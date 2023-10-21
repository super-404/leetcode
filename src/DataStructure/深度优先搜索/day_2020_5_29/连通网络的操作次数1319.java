package DataStructure.深度优先搜索.day_2020_5_29;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class 连通网络的操作次数1319 {

    public static void main(String[] args) {
        int n = 11;
        int[][] connections = {
                {1, 4}, {0, 3}, {1, 3}, {3, 7}, {2, 7}, {0, 1}, {2, 4}, {3, 6}, {5, 6}, {6, 7}, {4, 7}, {0, 7}, {5, 7}};
        // BFS s = new BFS ();
        union_find u = new union_find ();
        u.makeConnected (11, connections);
//        System.out.println (s.makeConnected (n, connections));
    }
}


//BFS解法
class BFS {
    public int makeConnected(int n, int[][] connections) {
        //如果节点的数量比边的还要多
        //        //那么无法连通
        //        if (connections.length <n-1) {
        //            return -1;
        //        }
        //        //除了这种情况以外
        //        //那么一定是可以连通的
        //        //连通需要的操作数就等于将图中的各个连通分量连起来
        //        //因此如果连通分量为n
        //        //需要n-1次操作
        LinkedList<ArrayList> lis = new LinkedList<> ();

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<> ();
        }
        //因为是无向图
        //因此
        for (int i = 0; i < connections.length; i++) {
            graph[connections[i][0]].add (connections[i][1]);
            graph[connections[i][1]].add ((connections[i][0]));
        }

        boolean isVisited[] = new boolean[n];
        int ConnectedComponent = 0;
        int remains = 0;
        int edge = 0;
        int vertex = 0;
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                edge = 0;
                vertex = 0;
                lis.add (graph[i]);
                isVisited[i] = true;
                while (!lis.isEmpty ()) {
                    ArrayList<Integer> k = lis.poll ();
                    vertex++;
                    for (int num : k
                    ) {
                        //判断是否处理过该节点
                        if (!isVisited[num]) {
                            lis.add (graph[num]);
                            isVisited[num] = true;
                        }
                    }
                }
                ConnectedComponent++;
            }
        }
        return ConnectedComponent - 1;
    }
}

//并查集解法
//并查集的解法思想上其实和BFS差不多

//都需要判断是否有多余的边，在两个节点之间
//这种解法更高效一些
class union_find {
    int parents[];
    int num;

    public int makeConnected(int n, int[][] connections) {
        parents = new int[n];
        num = n;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int count = 0;

        for (int i = 0; i < connections.length; i++) {
            //如果两个节点已经联通了，那么这根线就是多余的
            if (isSame (connections[i][0], connections[i][1])) {
                count++;
            }
            union (connections[i][0], connections[i][1]);
        }
        //num-1是额外需要连接的节点
        //count是多余的线
        if (count >= num - 1) {
            return num - 1;
        } else {
            return -1;
        }
    }

    public int find(int v) {
        while (v != parents[v]) {
            parents[v] = find (parents[v]);
        }
        return parents[v];
    }


    public void union(int v, int p) {
        int p1 = find (v);
        int p2 = find (p);
        if (p1 == p2)
            return;
        //每做一次连接操作说明需要额外连接的节点少一个
        num--;
        parents[p1] = p2;
    }


    public boolean isSame(int v, int p) {
        return find (v) == find (p);
    }
}
