package DataStructure.动态规划.背包问题;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 23:20
 **/
public class 榨取kkksc03P1855 {
    public static void main(String[] args) {
        solution ();
    }

    public static void solution() {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        int t = sc.nextInt ();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt ();
            b[i] = sc.nextInt ();
        }
        int dp[][] = new int[m + 1][t + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= a[i]; j--) {
                for (int k = t; k >= b[i]; k--) {
                    dp[j][k] = Math.max (dp[j][k], dp[j - a[i]][k - b[i]] + 1);
                }
            }
        }
        System.out.println (dp[m][t]);
    }
}
