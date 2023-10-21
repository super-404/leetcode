package DataStructure.深度优先搜索.day_2020_6_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 喧闹和富有851 {
    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int quiet[] = {3, 2, 5, 4, 6, 1, 7, 0};
        Solution s = new Solution ();
        System.out.println (Arrays.toString (s.loudAndRich (richer, quiet)));
    }
}

class Solution {
    ArrayList<Integer> ai[];
    int res[];

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        ai = new ArrayList[quiet.length];

        res = new int[quiet.length];

        for (int i = 0; i < quiet.length; i++) {
            ai[i] = new ArrayList ();
        }

        for (int i = 0; i < richer.length; i++) {
            ai[richer[i][1]].add (richer[i][0]);
        }

        LinkedList<ArrayList<Integer>> queue = new LinkedList ();

        for (int i = 0; i < quiet.length; i++) {
            queue.add (ai[i]);
            boolean visited[] = new boolean[quiet.length];
            int min = i;
            while (!queue.isEmpty ()) {
                ArrayList<Integer> temp = queue.poll ();
                for (Integer in : temp) {
                    if (!visited[in]) {
                        queue.add (ai[in]);
                        // visited[in] = true;
                        if (quiet[in] < quiet[min])
                            min = in;
                    }
                }
            }
            res[i] = min;
        }

        return res;
    }

    public void dfs(int index) {

    }
}
