package DataStructure.深度优先搜索;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-10-30 18:23
 **/
public class Solution {
    static char[][] maze;
    static boolean flag[][];
    static ArrayList<Pair> cordination = new ArrayList<> ();
    static ArrayList<ArrayList<Pair>> aap = new ArrayList<> ();

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        int m = in.nextInt ();
        maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.next ();
            maze[i] = s.toCharArray ();
        }
        new Solution ().solve (0, 0);

    }

    public void solve(int x, int y) {
        if (maze[x][y] == 'C') {
            maze[x][y] = 'A';
            cordination.add (new Pair (x + 1, y + 1));
            if (x == maze.length - 1 && y == maze[0].length - 1) {
                aap.add (new ArrayList<> (cordination));
                for (int i = 0; i < maze.length; i++) {
                    System.out.println (Arrays.toString (maze[i]));
                }
                for (Pair p : cordination) {
                    System.out.println ("(" + p.getKey () + "," + p.getValue () + ")");
                }
                System.out.println ("+++++++++++++++++++++++++++++++++++++++");
            }
        }
        //向下
        if (x + 1 < maze.length && maze[x + 1][y] == 'C') {
            solve (x + 1, y);
        }
        //向左
        if (y - 1 >= 0 && maze[x][y - 1] == 'C') {
            solve (x, y - 1);
        }
        //向上
        if (x - 1 >= 0 && maze[x - 1][y] == 'C') {
            solve (x - 1, y);
        }
        //向右
        if (y + 1 < maze[0].length && maze[x][y + 1] == 'C') {
            solve (x, y + 1);
        }
        Pair<Integer, Integer> pii = cordination.get (cordination.size () - 1);
        maze[pii.getKey () - 1][pii.getValue () - 1] = 'C';
        cordination.remove (cordination.size () - 1);
    }
}
