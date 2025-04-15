package DataStructure.图;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-29 10:45
 **/
public class 岛屿数量200 {
    int[][] visited;

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<> ();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    int[] coordinate = new int[2];
                    coordinate[0] = i;
                    coordinate[1] = j;
                    queue.add (coordinate);
                    while (!queue.isEmpty ()) {
                        int[] coordi = queue.poll ();
                        int row = coordi[0];
                        int colum = coordi[1];
                        visited[row][colum] = 1;
                        // int [] direction = {};
                        //考虑四个方向
                        if (row - 1 >= 0 && grid[row - 1][colum] == '1' && visited[row - 1][colum] == 0) {
                            coordinate = new int[2];
                            coordinate[0] = row - 1;
                            coordinate[1] = colum;
                            queue.add (coordinate);
                        }
                        if (row + 1 < grid.length && grid[row + 1][colum] == '1' && visited[row + 1][colum] == 0) {
                            coordinate = new int[2];
                            coordinate[0] = row + 1;
                            coordinate[1] = colum;
                            queue.add (coordinate);
                        }
                        if (colum - 1 >= 0 && grid[row][colum - 1] == '1' && visited[row][colum - 1] == 0) {
                            coordinate = new int[2];
                            coordinate[0] = row;
                            coordinate[1] = colum - 1;
                            queue.add (coordinate);
                        }
                        if (colum + 1 < grid[0].length && grid[row][colum + 1] == '1' && visited[row][colum + 1] == 0) {
                            coordinate = new int[2];
                            coordinate[0] = row;
                            coordinate[1] = colum + 1;
                            queue.add (coordinate);
                        }

                    }
                    ans++;
                }
            }
        }
        return ans;
    }

    private void add(Queue queue, int row, int colum, int[][] grid) {
        if (colum + 1 < grid[0].length && grid[row][colum] == '1' && visited[row][colum + 1] == 0) {
            int[] coordinate = new int[2];
            coordinate[0] = row - 1;
            coordinate[1] = colum;
            queue.add (coordinate);
        }
    }

    @Test
    public void test() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'1', '1', '0', '1', '1'}};
        numIslands (grid);
    }
}
