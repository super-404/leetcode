package DataStructure.动态规划;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-19 19:47
 **/
public class 最大平均值和的分组813 {

    public int splitArray(int[] nums, int k) {
        int len = nums.length;
        int dp[][] = new int[len + 1][k + 1];
        //前缀和计算
        int prefix[] = new int[len + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        for (int i = 1; i < prefix.length; i++) {
            dp[i][1] = prefix[i] / i;
        }
        for (int j = 2; j < dp[0].length; j++) {
            for (int i = 1; i < dp.length; i++) {
                for (int l = j - 1; l < i; l++) {
                    dp[i][j] = Math.min (dp[i][j],
                            dp[l][j - 1] + (prefix[i] - prefix[l]) / (i - l));
                }
            }
        }
        return dp[len][k];
    }

    @Test
    public void test() {
        int a[] = {7, 2, 5, 10, 8};
        System.out.println (splitArray (a, 2));
    }
}
