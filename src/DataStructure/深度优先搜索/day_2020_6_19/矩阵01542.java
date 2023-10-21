package DataStructure.深度优先搜索.day_2020_6_19;

import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.LinkedList;

public class 矩阵01542 {
    public static void main(String[] args) {
        int matrix[][] = {{1},
                {1},
                {1},
                {0}};
        Solution solution = new Solution ();
        solution.updateMatrix (matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println (Arrays.toString (matrix[i]));

        }

    }
}

class Solution {
    boolean visited[][];

    public int[][] updateMatrix(int[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];
        LinkedList<Integer> index = new LinkedList<> ();
        //  int count=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //   count=0;
                int x = i;
                int y = j;
                if (matrix[i][j] != 0) {
                    index.add (i * matrix[0].length + j);
                    visited[i][j] = true;
                    while (!index.isEmpty ()) {
                        int num = index.poll ();
                        x = num / matrix[0].length;
                        y = num % matrix[0].length;
                        if (x - 1 >= 0) {
                            if (matrix[x - 1][y] != 0) {
                                index.add ((x - 1) * matrix[0].length + y);
                            } else {
                                x = x - 1;
                                break;
                            }
                        }
                        if (y - 1 >= 0) {

                            if (matrix[x][y - 1] != 0) {
                                index.add ((x) * matrix[0].length + y - 1);
                            } else {
                                y = y - 1;
                                break;
                            }
                        }
                        if (x + 1 < matrix.length) {
                            if (matrix[x + 1][y] != 0) {
                                index.add ((x + 1) * matrix[0].length + y);
                            } else {
                                x = x + 1;
                                break;
                            }
                        }
                        if (y + 1 < matrix[0].length) {
                            if (matrix[x][y + 1] != 0) {
                                index.add ((x) * matrix[0].length + y + 1);
                            } else {
                                y = y + 1;
                                break;
                            }

                        }
                    }
                }
                index.clear ();
                matrix[i][j] = Math.abs (x - i) + Math.abs (y - j);
            }
        }
        return matrix;
    }


    public void dfs(int grid[][], int current, int x, int y) {
        if (grid[x][y] == 0) {
            return;
        }
        if (1 + current < grid[x][y] && visited[x][y]) {
            grid[x][y] = 1 + current;
        }
        if (!visited[x][y]) {
            grid[x][y] += current;
        }
        visited[x][y] = true;
        if (x - 1 >= 0) {
            dfs (grid, grid[x][y], x - 1, y);
        }
        if (y - 1 >= 0) {
            dfs (grid, grid[x][y], x, y - 1);
        }
        if (x + 1 < grid.length) {
            dfs (grid, grid[x][y], x + 1, y);
        }
        if (y + 1 < grid[0].length) {
            dfs (grid, grid[x][y], x, y + 1);
        }
    }
}
