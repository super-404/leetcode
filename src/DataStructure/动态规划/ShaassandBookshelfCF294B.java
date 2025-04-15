package DataStructure.动态规划;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 10:06
 **/
public class ShaassandBookshelfCF294B {

    public static void main(String[] args) {
        //   solution();

    }

    public static void solution() {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        in.nextLine ();
        int w[] = new int[n];
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt ();
            v[i] = in.nextInt ();
            in.nextLine ();
        }
        int sumw = Arrays.stream (w).sum ();
        int sumv = Arrays.stream (v).sum ();
        int dp[] = new int[sumw + 1];
        for (int i = 0; i < n; i++) {
            for (int j = sumw; j >= w[i]; j--) {
                dp[j] = Math.max (dp[j], dp[j - w[i]] + v[i]);
            }
        }
        for (int i = 0; i <= 200; i++) {
            if (i >= sumv - dp[i]) {
                System.out.println (i);
                return;
            }
        }
    }
}


class Main {
//    static final int M = 2005, N = 4005;
//    static long[] c = new long[M];


    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt ();
        int[] t = new int[n];
        int[] c = new int[n];
        int v = 0;
        long ans = 2000000000l; // 注意 ans 的初始值
        scanner.nextLine ();
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt ();
            c[i] = scanner.nextInt ();
            t[i]++;
            v = Math.max (v, t[i]);
            scanner.nextLine ();
        }
        v += n;   // 计算最大体积
        long[] dp = new long[v + 1];
        Arrays.fill (dp, Integer.MAX_VALUE);
        dp[0] = 0; // 对 dp 数组进行初始化
        int sum = Arrays.stream (c).sum ();
        for (int i = 0; i < n; i++) {
            for (int j = v; j >= t[i]; j--) {

                dp[j] = Math.min (dp[j], dp[j - t[i]] + c[i]); // 01 背包
            }
            System.out.println (Arrays.toString (dp));
        }
        //  Arrays.toString (dp);
        for (int i = n; i <= v; i++) {
            ans = Math.min (ans, dp[i]); // 寻找耗费最少的方案
        }
        System.out.println (ans);
        //    System.out.println(sum-dp[v]);
    }
}


class MainGPT {
    static final int M = 2005;
    static long[] c = new long[M];
    static long[] dp = new long[M];

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt ();
        int[] t = new int[M];

        for (int i = 1; i <= n; i++) {
            t[i] = scanner.nextInt ();
            c[i] = scanner.nextLong ();
        }

        Arrays.fill (dp, Integer.MAX_VALUE);
        dp[0] = 0; // 如果不扫描任何商品，支付为0

        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 0; j--) {
                for (int k = 0; k <= Math.min (t[i], j); k++) {
                    if (j - k >= 0) {
                        dp[j] = Math.min (dp[j], dp[j - k] + c[i]);
                    }
                }
                System.out.println (Arrays.toString (dp));
            }
        }

        long ans = Long.MAX_VALUE;
        for (int j = n; j < M; j++) {
            ans = Math.min (ans, dp[j]);
        }

        System.out.println (ans);
    }
}

