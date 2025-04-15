package DataStructure.动态规划.背包问题;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-10-27 14:59
 **/
public class 神奇的四次方数P1679 {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt ();
        int dp[] = new int[100000 + 1];
        Arrays.fill (dp, 20000);
        dp[0] = 0;
        int w[] = new int[18];
        for (int i = 0; i < w.length; i++) {
            w[i] = (int) Math.pow (i, 4);
        }
        for (int i = 1; i <= 17; i++) {
            for (int j = w[i]; j < dp.length; j++) {
                dp[j] = Math.min (dp[j], dp[j - w[i]] + 1);
            }
        }
        System.out.println (dp[n]);
    }

    @Test
    public void test() {
//        System.out.println (Math.pow (10,1.25));
//        System.out.println (Math.pow (17,4));
//        System.out.println (Math.pow (17.5,4));
//        System.out.println (Math.pow (18,4));
//        double  s = (Math.pow (5,4)+Math.pow(3,4))/1000;
//        //System.out.println ();
//        System.out.println (s-(706.0/1000));

    }
}
