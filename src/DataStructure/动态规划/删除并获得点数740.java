package DataStructure.动态规划;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-18 09:04
 **/
public class 删除并获得点数740 {
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        int dp[] = new int[10001];
        int score[] = new int[10001];
        for (int i = 0; i < len; i++) {
            score[nums[i]] += nums[i];
        }

        dp[0] = score[0];

        if (len == 1) {
            return dp[0];
        }

        dp[1] = score[0] > score[1] ? score[0] : score[1];

        for (int i = 2; i < score.length; i++) {
            dp[i] = Math.max (dp[i - 1], dp[i - 2] + score[i]);
        }
        return dp[dp.length - 1];
    }

    @Test
    public void test() {
        int a[] = {2, 2, 3, 3, 3, 4};
        deleteAndEarn (a);
    }
}
