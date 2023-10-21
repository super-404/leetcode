package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description: 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。
 * 地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，
 * 他必须穿过地下城并通过对抗恶魔来拯救公主。  骑士的初始健康点数为一个正整数。
 * 如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，
 * 因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
 * 其他房间要么是空的（房间里的值为 0），
 * 要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，
 * 则骑士的初始健康点数至少为 7。
 * @author: 饶嘉伟
 * @create: 2023-03-26 10:41
 **/
public class _174地下城游戏 {

    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int dp[][] = new int[r][c];
        int dpmin[][] = new int[r][c];
        dp[0][0] = dungeon[0][0];
        dpmin[0][0] = dungeon[0][0];
        int min = dungeon[0][0];
        for (int i = 1; i < c; i++) {
            dp[0][i] = dp[0][i - 1] + dungeon[0][i];
            dpmin[0][i] = Math.min (dpmin[0][i - 1], dp[0][i]);
        }
        for (int i = 1; i < r; i++) {
            dp[i][0] = dp[i - 1][0] + dungeon[i][0];
            dpmin[i][0] = Math.min (dpmin[i - 1][0], dp[i][0]);

        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (dpmin[i - 1][j] > dpmin[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + dungeon[i][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + dungeon[i][j];
                }
                dpmin[i][j] = Math.min (Math.max (dpmin[i - 1][j], dpmin[i][j - 1]), dp[i][j]);
            }
        }
        if (dp[r - 1][c - 1] > 0) {
            if (min > 0)
                return 1;
            else
                return -min + 1;
        } else {
            if (dp[r - 1][c - 1] > min) {
                return -min + 1;
            } else {
                return -dp[r - 1][c - 1] + 1;
            }
        }
    }
}
