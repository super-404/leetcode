package DataStructure.图;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description: 图的相关api及其实现
 * @author: 饶嘉伟
 * @create: 2020-11-28 18:00
 **/
public class Graph {
    //图的adjacency list
    ArrayList<Integer>[] bag;
    int V;
    int E;

    //给定顶点个数
    //初始化图
    public Graph(int V) {
        this.V = V;
        bag = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            bag[i] = new ArrayList<> ();
        }
    }

    public Graph(Scanner in) {
        this (in.nextInt ());
        int E = in.nextInt ();
        for (int i = 0; i < V; i++) {
            int v = in.nextInt ();
            int w = in.nextInt ();
            addEdge (v, w);
        }
    }

    //添加一条边
    public void addEdge(int v, int w) {
        bag[v].add (w);
        bag[w].add (v);
        this.E++;
    }

    //获得和顶点v相连的顶点
    public ArrayList<Integer> adj(int v) {
        if (v < V)
            return bag[v];
        else {
            System.err.println ("v 下标大于" + this.V);
        }
        return null;
    }

    //number of vertices;
    public int V() {
        return this.V;
    }

    //number of edges;
    public int E() {
        return this.E;
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int i = 0; i < V; i++) {
            s += i + ":";
            for (int w : bag[i]) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
