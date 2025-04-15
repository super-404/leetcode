package DataStructure.图;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-09-06 19:52
 **/
public class 连接所有点的最小费用1584 {
    public int minCostConnectPoints(int[][] points) {
        //long[][] g = new long[1001][1001];
        List<Graph> graphArrayList = new ArrayList<> ();
        //计算所有节点之间的距离
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int distance = Math.abs (points[i][0] - points[j][0])
                        + Math.abs (points[i][1] - points[j][1]);
                graphArrayList.add (new Graph (i, j, distance));
            }

        }
        int union[] = new int[1001];
        for (int j = 0; j < union.length; j++) {
            union[j] = j;
        }
        Collections.sort (graphArrayList);

        int res = 0;
        int edges = 0;
        for (Graph g : graphArrayList) {
            if (union[g.from] != union[g.to]) {
                res += g.w;
                int x = union[g.to];
                for (int i = 0; i < union.length; i++) {
                    if (union[i] == x)
                        union[i] = union[g.from];
                }
                //union[g.to] = union[g.from];
                edges++;
                if (edges == points.length - 1) {
                    return res;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int a[][] = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        System.out.println (new 连接所有点的最小费用1584 ().minCostConnectPoints (a));
    }

    class Graph implements Comparable<Graph> {
        int from;
        int to;
        int w;


        public Graph(int f, int t, int w) {
            this.from = f;
            this.to = t;
            this.w = w;
        }


        @Override
        public int compareTo(Graph o) {
            return this.w - o.w;
        }
    }

}
