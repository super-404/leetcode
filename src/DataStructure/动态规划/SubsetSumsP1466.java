package DataStructure.动态规划;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 09:05
 **/
public class SubsetSumsP1466 {
    public static void main(String[] args) {
        solution ();
    }

    public static void solution() {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int sum = (n * (n + 1)) / 2;
        if (sum % 2 != 0) {
            System.out.println (0);
            return;
        }
        long dp[] = new long[sum / 2 + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = sum / 2; j >= i; j--) {
                dp[j] += dp[j - i];
            }
        }
        System.out.println (dp[sum / 2] / 2);
    }
}
