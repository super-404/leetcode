package DataStructure.图;

/**
 * @program: leetcode
 * @description: 图的深度优先遍历
 * @author: 饶嘉伟
 * @create: 2020-11-28 19:18
 **/
public class DepthFirstSearch {
    private Graph g;
    private boolean[] marked;
    private int s;
    private int[] edgeTo;

    public DepthFirstSearch() {

    }

    public DepthFirstSearch(Graph g) {
        this.g = g;
        marked = new boolean[g.V ()];
    }

    public DepthFirstSearch(Graph g, int s) {
        this.g = g;
        this.s = s;
        marked = new boolean[g.V ()];
        edgeTo = new int[g.V ()];
        dfs (g, s);
    }

    public void printDfs() {
        for (int i = 0; i < g.V (); i++) {
            if (!marked[i])
                dfs (i);
        }
    }

    private void dfs(int v) {
        marked[v] = true;
        System.out.println ("marked:" + v);
        for (int i : g.adj (v)) {
            if (!marked[i]) {
                dfs (i);
            }
        }
    }

    //
    public void dfs(Graph g, int v) {
        marked[v] = true;
        System.out.println ("marked:" + v);
        for (int i : g.adj (v)) {
            if (!marked[i]) {
                edgeTo[i] = v;
                dfs (i);
            }
        }
    }

    //判断是否有路径从s to v
    private boolean hasPathTo(int v) {
        return marked[v];
    }
}
