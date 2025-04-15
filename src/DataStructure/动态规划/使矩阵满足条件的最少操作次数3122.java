package DataStructure.动态规划;

import org.junit.Test;

/**
 * @program: leetcode
 * @description: 给你一个大小为 m x n 的二维矩形 grid 。每次 操作 中，
 * <p>
 * 你可以将 任一 格子的值修改为 任意 非负整数。
 * 完成所有操作后，你需要确保每个格子 grid[i][j] 的值满足：
 * <p>
 * 如果下面相邻格子存在的话，它们的值相等，也就是 grid[i][j] == grid[i + 1][j]
 * （如果存在）。
 * 如果右边相邻格子存在的话，它们的值不相等，也就是 grid[i][j] != grid[i][j + 1]
 * （如果存在）。
 * <p>
 * 请你返回需要的 最少 操作数目。
 * @author: 饶嘉伟
 * @create: 2024-04-25 08:43
 **/
public class 使矩阵满足条件的最少操作次数3122 {
    public int minimumOperations(int[][] grid) {
        //每一列中的数字记录下,从1到9
        int column = grid[0].length;
        int row = grid.length;
        int c[][] = new int[grid[0].length][10];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                c[i][grid[j][i]]++;
            }
        }
        int res = dfs (0, 0, c);

        return row * column - res;
    }

    //第几列，数字，数组c
    public int dfs(int i, int num, int[][] c) {
        if (i == c.length) {
            return 0;
        }
        int res = 0;
        for (int j = 0; j < 9; j++) {
            //把第i列设置成想要的数字
            res = Math.max (res, dfs (i + 1, j, c) + c[i][j]);
        }
        return res;
    }

    @Test
    public void test() {
        int grid[][] = {{1}};
        System.out.println (minimumOperations (grid));
    }
}
