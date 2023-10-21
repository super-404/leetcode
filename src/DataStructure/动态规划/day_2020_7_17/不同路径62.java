package DataStructure.动态规划.day_2020_7_17;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-07-17 17:48
 **/
public class 不同路径62 {
}

class Solution {

    public int uniquePaths(int m, int n) {
        if (n == 0) {
            return 1;
        }
        int grid[][] = new int[m][n];
        grid[0][0] = 0;
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = 1;
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] = 1;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];

            }
        }
        return grid[m - 1][n - 1];
    }
}
