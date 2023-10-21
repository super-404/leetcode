package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2023-03-14 22:48
 **/

public class _LCP07传递信息 {

    public static void main(String[] args) {

    }
}

class Solution1123 {

    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        //initialize dp
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < relation.length; i++) {
                int start = relation[j][0];
                int end = relation[j][1];
                dp[i][end] += dp[i - 1][start];
            }

        }
        return dp[k][n - 1];
    }
}
