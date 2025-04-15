package DataStructure.动态规划.背包问题;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-27 15:33
 **/
public class 投资的最大效益P1853 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int m = in.nextInt ();
        int y = in.nextInt ();
        int k = in.nextInt ();
        int w[] = new int[k];
        int v[] = new int[k];
        for (int i = 0; i < k; i++) {
            w[i] = in.nextInt ();
            v[i] = in.nextInt ();
        }
        int ans = 0;
        for (int i = 0; i < y; i++) {
            int dp[] = new int[(m + ans) / 1000 + 1];
            for (int j = 0; j < k; j++) {
                for (int l = w[j] / 1000; l <= dp.length - 1; l++) {
                    dp[l] = Math.max (dp[l], dp[l - w[j] / 1000] + v[j]);
                }
            }
            ans += dp[(m + ans) / 1000];
        }
        System.out.println (ans + m);
    }
}
