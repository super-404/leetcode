package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-19 08:57
 **/
public class 等差数列划分413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;
        int res = 0;
        for (int i = 2; i < dp.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            } else {
                dp[i] = 0;
            }
        }
        return res;
    }
}
