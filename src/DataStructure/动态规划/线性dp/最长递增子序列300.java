package DataStructure.动态规划.线性dp;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-08 09:17
 **/
public class 最长递增子序列300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill (dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max (max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = (res > dp[i]) ? res : dp[i];
        }
        return res;
    }
}
