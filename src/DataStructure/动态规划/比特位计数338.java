package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-04-19 10:06
 **/
public class 比特位计数338 {
    public int[] countBits(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            //dp[i]取决于i是否是偶数以及，向右移一位之后的数据
            dp[i] = dp[i / 2] + (i & 1);
        }
        return dp;
    }
}
