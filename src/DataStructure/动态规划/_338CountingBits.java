package DataStructure.动态规划;

/**
 * @program: leetcode
 * @description: Given an integer n,
 * return an array ans of length n + 1 such that for each i (0 <= i <= n),
 * ans[i] is the number of 1's in the binary representation of i.
 * @author: 饶嘉伟
 * @create: 2023-03-10 00:19
 **/

public class _338CountingBits {

    public static void main(String[] args) {
        for (int i : solution (5)) {
            System.out.println (i);
        }

    }

    public static int[] solution(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        if (n == 0)
            return dp;
        dp[1] = 1;
        if (n <= 1)
            return dp;

        for (int i = 2; i < dp.length; ) {
            int j = 0;
            int k = i;
            while (j < k && j < dp.length && i < dp.length) {
                dp[i] = dp[j] + 1;
                i++;
                j++;
            }
        }
        return dp;
    }
}
