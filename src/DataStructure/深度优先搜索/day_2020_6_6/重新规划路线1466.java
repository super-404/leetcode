package DataStructure.深度优先搜索.day_2020_6_6;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;

public class 重新规划路线1466 {
    public static void main(String[] args) {
        int a[][] = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        Solution s = new Solution ();
        System.out.println (s.minReorder (6, a));
    }
}

class Solution {
    ArrayList<int []> li[];

    public int minReorder(int n, int[][] connections) {
        if (n == 0)
            return 0;
        li = new ArrayList[n];
        //构建一个有向的邻接表
        for (int i = 0; i < n; i++) {
            li[i] = new ArrayList<> ();
        }
        boolean isVisited[] = new boolean[n];
        int res = 0;
        LinkedList<ArrayList> linkedList = new LinkedList ();
        for (int i = 0; i < n - 1; i++) {
            //正向边
            int a[]={connections[i][1],0};

            int b[]={connections[i][0],1};

            li[connections[i][0]].add (a);
            //反向边
            li[connections[i][1]].add (b);
        }
        linkedList.add (li[0]);
        isVisited[0]=true;
        while (!linkedList.isEmpty ()) {
            ArrayList<int []> ai = linkedList.poll ();
            for (int [] a:ai) {
                int x=a[0];
                int y=a[1];
                if(!isVisited[x]) {
                    if (y == 0) {
                        res++;
                    }
                    linkedList.add (li[x]);
                    isVisited[x]=true;
                }
            }
        }
        return res;
    }
}
