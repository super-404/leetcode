package DataStructure.动态规划.背包问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 22:45
 **/
public class NASA的食物计划P1507 {
    static class P {
        int t;//体积
        int v; //重量
        int k;  //卡路里

        P(int t, int v, int h) {
            this.t = t;
            this.v = v;
            this.k = h;
        }
    }

    public static void main(String[] args) {
        solution ();
    }

    public static void solution() {
        Scanner in = new Scanner (System.in);
        int h = in.nextInt ();//体积
        int t = in.nextInt ();//重量
        in.nextLine ();
        int k = in.nextInt ();
        // int dp [] = new int [h+1];
        P ps[] = new P[k];
        for (int i = 0; i < k; i++) {
            ps[i] = new P (in.nextInt (), in.nextInt (), in.nextInt ());
            in.nextLine ();
        }
        int dp[][] = new int[h + 1][t + 1];
        for (int i = 0; i < k; i++) {
            for (int j = h; j >= ps[i].t; j--) {
                for (int l = t; l >= ps[i].v; l--) {
                    dp[j][l] = Math.max (dp[j][l], dp[j - ps[i].t][l - ps[i].v] + ps[i].k);
                }
            }
        }
        System.out.println (dp[h][t]);
        ;
    }

}
