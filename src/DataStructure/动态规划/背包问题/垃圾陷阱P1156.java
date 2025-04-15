package DataStructure.动态规划.背包问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 22:05
 **/
public class 垃圾陷阱P1156 {
    static class P {
        int t;
        int v;
        int h;

        P(int t, int v, int h) {
            this.t = t;
            this.v = v;
            this.h = h;
        }
    }

    public static void main(String[] args) {
        solution ();
    }

    public static void solution() {
        Scanner in = new Scanner (System.in);
        int h = in.nextInt ();
        int k = in.nextInt ();
        in.nextLine ();
        int dp[] = new int[h + 1];
        P ps[] = new P[k];
        for (int i = 0; i < k; i++) {
            ps[i] = new P (in.nextInt (), in.nextInt (), in.nextInt ());
            in.nextLine ();
        }
        Arrays.sort (ps, Comparator.comparingInt (a -> a.t));
        //   Arrays.fill (dp,-1);
        dp[0] = 10;

        for (int i = 0; i < k; i++) {
            for (int j = h; j >= 0; j--) {
                if (dp[j] >= ps[i].t) {
                    if (j + ps[i].h >= h) {
                        System.out.println (ps[i].t);
                        return;
                    }
                    dp[j + ps[i].h] = Math.max (dp[j + ps[i].h], dp[j]);
                    dp[j] += ps[i].v;
                }
            }
        }
        System.out.println (dp[0]);
    }

}
