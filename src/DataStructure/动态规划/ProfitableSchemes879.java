package DataStructure.动态规划;


import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-24 16:35
 **/
public class ProfitableSchemes879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][] = new int[minProfit + 1][n + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        int MOD = 1_000_000_000 + 7;
        for (int i = 0; i < profit.length; i++) {
            for (int j = minProfit; j >= 0; j--) {
                for (int k = n; k >= group[i]; k--) {
                    dp[j][k] = (dp[j][k] + dp[Math.max (0, j - profit[i])][k - group[i]]) % MOD;
                }
            }
            for (int j = 0; j < dp.length; j++) {
                System.out.println (Arrays.toString (dp[j]));
            }
        }
        return dp[minProfit][n];
    }

    @Test
    public void test() {
        int n = 5;
        int minProfit = 3;
        int group[] = {2, 2};
        int profit[] = {1, 3};
        profitableSchemes (n, minProfit, group, profit);
    }
}
