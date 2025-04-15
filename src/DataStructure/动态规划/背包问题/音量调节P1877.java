package DataStructure.动态规划.背包问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 23:33
 **/
public class 音量调节P1877 {
    static int min = 0;
    static int max;
    static int a[];
    static int dp[][];

    public static void main(String[] args) {

        solution ();
    }

    public static void solution() {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        a = new int[n];
        int begin = sc.nextInt ();
        max = sc.nextInt ();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt ();
        }
        dp = new int[n][max + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill (dp[i], -1);
        }
        System.out.println (dfs (begin, 0));
    }

    public static int dfs(int curVolume, int idx) {

        if (curVolume < min || curVolume > max) {
            return -1;
        }
        if (idx == a.length) {
            return curVolume;
        }

        if (dp[idx][curVolume] != -1) {
            return dp[idx][curVolume];
        }
        // int ans = 0;
        int left = dfs (curVolume - a[idx], idx + 1);
        int right = dfs (curVolume + a[idx], idx + 1);
        return dp[idx][curVolume] = Math.max (left, right);
    }
}
