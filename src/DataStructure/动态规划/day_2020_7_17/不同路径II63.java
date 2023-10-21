package DataStructure.动态规划.day_2020_7_17;

import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-17 18:16
 **/
public class 不同路径II63 {
    public static void main(String[] args) {

        new Solution4 ().uniquePathsWithObstacles (new int[][]{
                {0}});
    }
}

class Solution4 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 1;
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 1;
        }
        int grid[][] = obstacleGrid;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        grid[0][0] = 1;
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][0] == Integer.MIN_VALUE)
                break;
            else {
                grid[i][0] = 1;
            }
        }
        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i] == Integer.MIN_VALUE)
                break;
            grid[0][i] = 1;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == Integer.MIN_VALUE)
                    continue;
                if (grid[i - 1][j] != Integer.MIN_VALUE)
                    grid[i][j] += grid[i - 1][j];
                if (grid[i][j - 1] != Integer.MIN_VALUE)
                    grid[i][j] += grid[i][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println (Arrays.toString (grid[i]));
        }
        ;
        return grid[m - 1][n - 1];
    }
}
