package DataStructure.动态规划;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-25 09:29
 **/
public class yyy2015c01的U盘P2370 {
    public static void main(String[] args) {
        solution2 ();
    }

    //二分法优化
    public static void solution2() {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        int v = in.nextInt ();
        int s = in.nextInt ();
        int value[] = new int[n];
        int volume[] = new int[n];
        in.nextLine ();
        for (int i = 0; i < n; i++) {
            volume[i] = in.nextInt ();
            value[i] = in.nextInt ();
            in.nextLine ();
        }


        int max = Arrays.stream (volume).max ().getAsInt ();
        int left = 1;
        int right = max;
        int ans = -1;
        while (left <= right) {
            int dp[] = new int[s + 1];
            int mid = (right - left) / 2 + left;
            for (int j = 0; j < n; j++) {
                for (int k = s; k >= volume[j]; k--) {
                    if (mid >= volume[j])
                        dp[k] = Math.max (dp[k], dp[k - volume[j]] + value[j]);
                }
            }
            if (dp[s] >= v) {
                ans = mid;
                right = mid - 1;
                //return;
            } else if (dp[s] < v) {
                left = mid + 1;
            }
        }
        if (ans == -1)
            System.out.println ("No Solution!");
        else {
            System.out.println (ans);
        }
    }

    public static void solution() {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        int v = in.nextInt ();
        int s = in.nextInt ();
        int value[] = new int[n];
        int volume[] = new int[n];
        in.nextLine ();
        for (int i = 0; i < n; i++) {
            volume[i] = in.nextInt ();
            value[i] = in.nextInt ();
            in.nextLine ();
        }


        int max = Arrays.stream (volume).max ().getAsInt ();
        for (int i = 1; i <= max; i++) {
            int dp[] = new int[s + 1];
            for (int j = 0; j < n; j++) {
                for (int k = s; k >= volume[j]; k--) {
                    if (i >= volume[j])
                        dp[k] = Math.max (dp[k], dp[k - volume[j]] + value[j]);
                }
            }
            if (dp[s] >= v) {
                System.out.println (i);
                return;
            }
        }
        System.out.println ("No Solution!");
    }
}
