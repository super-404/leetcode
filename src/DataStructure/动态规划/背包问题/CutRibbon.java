package DataStructure.动态规划.背包问题;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-27 15:54
 **/
public class CutRibbon {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        int w[] = new int[3];
        w[0] = in.nextInt ();
        w[1] = in.nextInt ();
        w[2] = in.nextInt ();
        int dp[] = new int[n + 1];
        Arrays.fill (dp, -10000);
        dp[0] = 0;
        for (int i = 0; i < w.length; i++) {
            for (int j = w[i]; j <= n; j++) {
                dp[j] = Math.max (dp[j], dp[j - w[i]] + 1);
            }
            System.out.println (Arrays.toString (dp));
        }
        System.out.println (dp[n]);
    }
}
