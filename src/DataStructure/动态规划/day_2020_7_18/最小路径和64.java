package DataStructure.动态规划.day_2020_7_18;

/**
 * @program: leetcode
 * @description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步
 * @author: 饶嘉伟
 * @create: 2020-07-18 14:58
 **/


public class 最小路径和64 {


}

//这里利用了滚动数组优化了一下空间
//因为发现他推导出下一个点的值只需要使用左边的值和上面的值
/*例子  1 3 1
       1 5 1
       4 2 7
dp[i][j] 1 4 5
         2
在这种情况下，对于下一个值dp[j]得推导，只需要2 4
而dp[j-1]=2 dp[j]因为没有发生改变仍然是4
因此   dp[j]=Math.min(dp[j-1],dp[j])+grid[i][j];
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int dp[] = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    if (i == 0) {
                        dp[j] = dp[j - 1] + grid[i][j];
                    } else {
                        dp[j] = Math.min (dp[j - 1], dp[j]) + grid[i][j];
                    }
                }
            }
        }
        return dp[grid[0].length - 1];
    }
}
