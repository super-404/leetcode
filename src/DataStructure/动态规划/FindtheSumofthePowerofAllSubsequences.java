package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-24 18:18
 **/
public class FindtheSumofthePowerofAllSubsequences {

    public int sumOfPower(int[] nums, int k) {

        int dp[] = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = k; j >= 0; j--) {
                dp[j] = (dp[j] * 2 + dp[Math.max (0, j - nums[i])]);
            }
        }
        return dp[k];
    }
}
