package DataStructure.动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-18 07:51
 **/
public class 最长等差数列1027 {

    public int longestArithSeqLength(int[] nums) {
        int len = nums.length;
        final int diff = 500;
        int dp[][][] = new int[len][len][diff];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                Arrays.fill (dp[i][j], 1);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int d = 0;
                if (nums[j] - nums[i] < 0) {
                    d = 500 + (nums[j] - nums[i]);
                } else {
                    d = nums[j] - nums[i];
                }
                int max = dp[i][j][d];
                for (int k = i; k >= 0; k--) {
                    dp[i][j][d] = Math.max (dp[k][i][d] + 1, max);
                    max = dp[i][j][d];
                    res = max > res ? max : res;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int a[] = {3, 6, 9, 12};
        int res = longestArithSeqLength (a);
        System.out.println (res);
    }
}
