package DataStructure.动态规划.背包问题;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2025-04-15 22:32
 **/
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream (nums).sum ();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
