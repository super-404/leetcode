package DataStructure.Union_Find_Sets.leetcode_union练习;

import java.lang.management.LockInfo;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: 饶嘉伟
 * @Description
 *  利用bfs或者dfs均可
 * @Date: 2020/3/28 16:28
 * @Para: a
 * @retun: a
 **/

public class numIsLand131 {
    public static void main(String[] args) {
        char[][] board = {
                {'1'},
                {'1'},
                {'1'},
                {'0'}
    };
    numIsLand131 numIsLand131 = new numIsLand131 ();

//        System.out.println (numIsLand131.solutionDFS (board));
        System.out.println (solution (board));


    }

    public static int solution(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int col=grid[0].length;
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {

                    LinkedList<Integer> qc = new LinkedList<Integer> ();
                    //转换坐标的小技巧
                    qc.add (i*col+j);
                    grid[i][j] = '2';

                    while (!qc.isEmpty ()) {
                        int g = qc.remove ();
                        int m=g/col;
                        int n=g%col;
                        //将该点的上下左右都加入到队列中
                        if (m - 1 >= 0 && grid[m - 1][n] == '1') {
                                qc.add ((m-1)*col+n);
                                grid[m - 1][n] = '2';
                            }
                            if (m + 1 <= grid.length - 1 && grid[m + 1][n] == '1') {
                                qc.add ((m+1)*col+n);
                                grid[m + 1][n] = '2';
                            }
                            if (n - 1 >= 0 && grid[m][n - 1] == '1') {
                                qc.add ((m)*col+n-1);
                                grid[m][n- 1] = '2';
                            }
                            if (n + 1 <= grid[0].length-1 && grid[m][n + 1] == '1') {
                                qc.add ((m)*col+n+1);
                                grid[m][n + 1] = '2';
                            }
                        }
                     //队列遍历完毕，岛屿加一
                    total++;
                }

            }
        }

        return total;

    }

    public int solutionDFS(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs (i, j, grid);
                    total++;
                }
            }
        }
        return total;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            if (i - 1 >= 0) {
                dfs (i - 1, j, grid);
            }
            if (i + 1 <= grid.length - 1) {
                dfs (i + 1, j, grid);
            }
            if (j - 1 >= 0) {
                dfs (i, j - 1, grid);
            }
            if (j + 1 <= grid[0].length - 1) {
                dfs (i, j + 1, grid);
            }
        }
    }

}
