package DataStructure.图;

import org.junit.Test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-29 09:38
 **/
public class 所有可能的路径797 {
    List<List<Integer>> res = new ArrayList<> ();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> li = new ArrayList<> ();
        ans (graph, 0, li);
        return res;
    }

    private void ans(int[][] graph, int start, List<Integer> li) {
        li.add (start);
        if (start == graph.length - 1) {
            res.add (new ArrayList<> (li));
            li.remove ((Integer) start);
            return;
        }
        for (int i = 0; i < graph[start].length; i++) {
            ans (graph, graph[start][i], li);
        }
    }

    private void bfs(int[][] graph) {
        List<List<Integer>> res = new ArrayList<> ();
        int size = graph.length;
        Queue<List<Integer>> queue = new LinkedList<> ();

        queue.offer (Arrays.asList (0));

        while (!queue.isEmpty ()) {
            int n = queue.size ();
            for (int i = 0; i < n; i++) {
                List<Integer> cul = queue.poll ();
                int last = cul.get (cul.size () - 1);
                if (last == size - 1) {
                    res.add (cul);
                    continue;
                }
                int[] dist = graph[last];
                for (int num : dist) {
                    List<Integer> list = new ArrayList<> (cul);
                    list.add (num);
                    queue.offer (list);
                }
            }
        }
    }

    @Test
    public void test() {

        int a[][] = {{1, 2}, {3}, {3}, {}};
        bfs (a);

    }
}
