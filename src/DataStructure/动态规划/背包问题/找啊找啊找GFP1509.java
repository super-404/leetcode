package DataStructure.动态规划.背包问题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-26 00:03
 **/
public class 找啊找啊找GFP1509 {
    public static void main(String[] args) {
        solution ();
    }

    public static void solution() {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        int rmb[] = new int[n];
        int rp[] = new int[n];
        int time[] = new int[n];

        for (int i = 0; i < n; i++) {
            rmb[i] = in.nextInt ();
            rp[i] = in.nextInt ();
            time[i] = in.nextInt ();
        }

        int m = in.nextInt ();
        int r = in.nextInt ();
        int dpTime[][] = new int[m + 1][r + 1];
        int dpNum[][] = new int[m + 1][r + 1];
//        for (int i = 0; i <m+1; i++) {
//            Arrays.fill (dpTime[i],20000000);
//        }

        dpTime[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= rmb[i]; j--) {
                for (int k = r; k >= rp[i]; k--) {
                    if (dpNum[j][k] < dpNum[j - rmb[i]][k - rp[i]] + 1) {
                        dpNum[j][k] = dpNum[j - rmb[i]][k - rp[i]] + 1;
                        dpTime[j][k] = dpTime[j - rmb[i]][k - rp[i]] + time[i];
                    } else if (dpNum[j][k] == dpNum[j - rmb[i]][k - rp[i]] + 1) {
                        dpTime[j][k] = Math.min (dpTime[j][k], dpTime[j - rmb[i]][k - rp[i]] + time[i]);
                    }

                }
            }
        }
        System.out.println (dpTime[m][r]);
    }
}
