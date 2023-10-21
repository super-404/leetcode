package DataStructure.深度优先搜索.day_2020_6_2;

import java.util.Arrays;

public class 飞地的数量1020 {
    public static void main(String[] args) {
        Solution s = new Solution ();
        int grid[][]
                =
                {{0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                        {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                        {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                        {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                        {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                        {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                        {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};

        System.out.println (s.numEnclaves (grid));
    }
}

class Solution {
    Solution() {
        System.out.println ();
        this.count = 0;
    }

    int count = 0;
    boolean off = false;

    public int numEnclaves(int[][] A) {
        int a[][] = A;
        if (a.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    count = 0;
                    off = false;
                    dfs (a, i, j);
                    if (!off) {
                        res += count;
                    }
                }
            }
        }
        return res;
    }

    public void dfs(int grid[][], int x, int y) {
        if (grid[x][y] != 1) {
            return;
        }
        grid[x][y] = 2;
        count++;
        if (x <= 0 || y <= 0 || x >= grid.length - 1 || y >= grid[0].length - 1) {
            off = true;
        }
        if (x - 1 >= 0 && y < grid[0].length) {
            dfs (grid, x - 1, y);
        }
        if (x < grid.length && y - 1 >= 0) {
            dfs (grid, x, y - 1);
        }
        if (x + 1 < grid.length && y < grid[0].length) {
            dfs (grid, x + 1, y);
        }
        if (x < grid.length && y + 1 < grid[0].length) {
            dfs (grid, x, y + 1);
        }

    }
}
