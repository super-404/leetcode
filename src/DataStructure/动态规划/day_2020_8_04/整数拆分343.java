package DataStructure.动态规划.day_2020_8_04;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * @author: 饶嘉伟
 * @create: 2020-08-04 15:36
 **/
public class 整数拆分343 {
    public static void main(String[] args) {

        new Solution ().integerBreak (10);
    }
}

class Solution {
    public int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        if (n <= 2)
            return 1;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max (dp[i], (dp[i - j]) * j);
            }
        }
        dp[2] = 1;
        dp[3] = 2;
        System.out.println (Arrays.toString (dp));
        return dp[n];
    }

    //    //根据数学结论，将一个整数尽可能的拆成3+3+3...的形式，得到的乘积最大
    //也就是尽可能拆成3
    public int integerBreak1(int n) {
        int max = 1;
        if (n == 2 || n == 3)
            return n - 1;
        for (; n > 4; n -= 3) {
            max *= 3;
        }
        return max * n;
    }
}
