package DataStructure.动态规划.day_2020_8_03;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 饶嘉伟
 * @create: 2020-08-03 14:55
 **/
public class 零钱兑换322 {
    public static void main(String[] args) {
        new Solution2 ().coinChange (new int[]{3, 2, 5}, 11);
    }
}

class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill (dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min (dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        System.out.println (Arrays.toString (dp));
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
